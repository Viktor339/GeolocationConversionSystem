package com.conversionsysetem.geolocationconversionsystem.service;

import com.conversionsysetem.geolocationconversionsystem.controller.request.ReverseGeocodingRequest;
import com.conversionsysetem.geolocationconversionsystem.entity.Address;
import com.conversionsysetem.geolocationconversionsystem.entity.GeocodingResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {ReverseGeocodeControllerService.class, AddressAndCoordinatesBuilderService.class,
        FindValidLocationAddressService.class, ProxySendRequestService.class})
@ExtendWith(SpringExtension.class)
class ReverseGeocodeControllerServiceTest {
    @MockBean
    private AddressAndCoordinatesBuilderService addressAndCoordinatesBuilderService;

    @MockBean
    private FindValidLocationAddressService findValidLocationAddressService;

    @MockBean
    private ProxySendRequestService proxySendRequestService;

    @Autowired
    private ReverseGeocodeControllerService reverseGeocodeControllerService;

    @Test
    void testGetReverseGeocoding() throws IOException {
        ReverseGeocodingRequest reverseGeocodingRequest = new ReverseGeocodingRequest();
        GeocodingResult geocodingResult = new GeocodingResult();
        geocodingResult.setGeocodingObjectInformation(new ArrayList<>());
        when(this.proxySendRequestService.send(any())).thenReturn(geocodingResult);
        Address address = new Address("Street");
        when(this.findValidLocationAddressService.find(any())).thenReturn(address);
        when(this.addressAndCoordinatesBuilderService.buildCoordinates(any()))
                .thenReturn("Coordinates");
        Assertions.assertEquals(address,
                this.reverseGeocodeControllerService.getReverseGeocoding(reverseGeocodingRequest));
    }
}

