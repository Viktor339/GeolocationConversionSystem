package com.conversionsysetem.geolocationconversionsystem.service;

import com.conversionsysetem.geolocationconversionsystem.controller.request.GeocodingRequest;
import com.conversionsysetem.geolocationconversionsystem.entity.GeocodingResult;
import com.conversionsysetem.geolocationconversionsystem.entity.Geometry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {GeocodeControllerService.class, AddressAndCoordinatesBuilderService.class,
        ProxySendRequestService.class})
@ExtendWith(SpringExtension.class)
class GeocodeControllerServiceTest {
    @MockBean
    private AddressAndCoordinatesBuilderService addressAndCoordinatesBuilderService;

    @Autowired
    private GeocodeControllerService geocodeControllerService;

    @MockBean
    private ProxySendRequestService proxySendRequestService;

    @Test
    void testGetGeocoding_ShouldReturnGeometryList() throws IOException {
        List<Geometry> geometryList = new ArrayList<>();
        GeocodingResult geocodingResult = new GeocodingResult();
        geocodingResult.setGeocodingObjectInformation(new ArrayList<>());
        when(this.proxySendRequestService.send(any())).thenReturn(geocodingResult);
        when(this.addressAndCoordinatesBuilderService.buildAddress(any())).thenReturn("Address");

        GeocodingRequest geocodingRequest = new GeocodingRequest();
        assertTrue(this.geocodeControllerService.getGeocoding(geocodingRequest).isEmpty());
        verify(this.proxySendRequestService).send(any());
        verify(this.addressAndCoordinatesBuilderService).buildAddress(any());
        Assertions.assertEquals(geometryList, this.geocodeControllerService.getGeocoding(geocodingRequest));

    }
}

