package com.conversionsysetem.geolocationconversionsystem.service;

import com.conversionsysetem.geolocationconversionsystem.controller.request.GeocodingRequest;
import com.conversionsysetem.geolocationconversionsystem.controller.request.ReverseGeocodingRequest;
import com.conversionsysetem.geolocationconversionsystem.service.exception.BadRequestException;
import com.conversionsysetem.geolocationconversionsystem.service.exception.LanguageNotValidException;
import com.conversionsysetem.geolocationconversionsystem.service.exception.LatitudeNotValidException;
import com.conversionsysetem.geolocationconversionsystem.service.exception.LongitudeNotValidException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ContextConfiguration(classes = {AddressAndCoordinatesBuilderService.class})
@ExtendWith(SpringExtension.class)
class AddressAndCoordinatesBuilderServiceTest {

    @Autowired
    private AddressAndCoordinatesBuilderService addressAndCoordinatesBuilderService;

    @Test
    void testBuildAddress_ShouldThrowBadRequestException() throws BadRequestException {
        GeocodingRequest geocodingRequest = new GeocodingRequest();

        assertThrows(BadRequestException.class, () -> addressAndCoordinatesBuilderService.buildAddress(geocodingRequest));
    }

    @Test
    void testBuildCoordinates_ShouldThrowLanguageNotValidException() throws LanguageNotValidException {
        ReverseGeocodingRequest reverseGeocodingRequest = new ReverseGeocodingRequest();
        reverseGeocodingRequest.setLatitude(91.0);
        reverseGeocodingRequest.setLongitude(-180.0);
        reverseGeocodingRequest.setLanguage("language");

        assertThrows(LanguageNotValidException.class, () -> addressAndCoordinatesBuilderService.buildCoordinates(reverseGeocodingRequest));
    }

    @Test
    void testBuildAddress_ShouldReturnString() {
        GeocodingRequest geocodingRequest = new GeocodingRequest();
        geocodingRequest.setCity("City");
        geocodingRequest.setHouse("House");
        geocodingRequest.setStreet("Street");
        assertEquals("language=en&address=HouseStreetCity",
                this.addressAndCoordinatesBuilderService.buildAddress(geocodingRequest));
    }

    @Test
    void testBuildCoordinates_ShouldThrowBadRequestException() throws BadRequestException {
        ReverseGeocodingRequest reverseGeocodingRequest = new ReverseGeocodingRequest();

        assertThrows(BadRequestException.class, () -> addressAndCoordinatesBuilderService.buildCoordinates(reverseGeocodingRequest));
    }

    @Test
    void testBuildCoordinates_ShouldThrowLatitudeNotValidException() throws LatitudeNotValidException {
        ReverseGeocodingRequest reverseGeocodingRequest = new ReverseGeocodingRequest();
        reverseGeocodingRequest.setLatitude(91.0);
        reverseGeocodingRequest.setLongitude(-181.0);
        reverseGeocodingRequest.setLanguage("en");

        assertThrows(LatitudeNotValidException.class, () -> addressAndCoordinatesBuilderService.buildCoordinates(reverseGeocodingRequest));
    }

    @Test
    void testBuildCoordinates_ShouldThrowLongitudeNotValidException() throws LongitudeNotValidException {
        ReverseGeocodingRequest reverseGeocodingRequest = new ReverseGeocodingRequest();
        reverseGeocodingRequest.setLatitude(89.0);
        reverseGeocodingRequest.setLongitude(-181.0);
        reverseGeocodingRequest.setLanguage("en");

        assertThrows(LongitudeNotValidException.class, () -> addressAndCoordinatesBuilderService.buildCoordinates(reverseGeocodingRequest));
    }

    @Test
    void testBuildCoordinates_ShouldReturnString() {
        ReverseGeocodingRequest reverseGeocodingRequest = new ReverseGeocodingRequest();
        reverseGeocodingRequest.setLongitude(10.0);
        reverseGeocodingRequest.setLatitude(10.0);
        reverseGeocodingRequest.setLanguage("en");
        assertEquals("latlng=10.0%2C10.0&language=en",
                this.addressAndCoordinatesBuilderService.buildCoordinates(reverseGeocodingRequest));
    }

}

