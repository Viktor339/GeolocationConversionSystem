package com.conversionsysetem.geolocationconversionsystem.service;

import com.conversionsysetem.geolocationconversionsystem.entity.GeocodingObjectInformation;
import com.conversionsysetem.geolocationconversionsystem.entity.GeocodingResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = {FindValidLocationAddressService.class})
@ExtendWith(SpringExtension.class)
class FindValidLocationAddressServiceTest {
    @Autowired
    private FindValidLocationAddressService findValidLocationAddressService;

    @Test
    void testFind_ShouldReturnAddress() {

        GeocodingObjectInformation geocodingObjectInformation = new GeocodingObjectInformation();
        geocodingObjectInformation.setFormattedAddress("Address");

        ArrayList<GeocodingObjectInformation> geocodingObjectInformationList = new ArrayList<>();
        geocodingObjectInformationList.add(geocodingObjectInformation);

        GeocodingResult geocodingResult = new GeocodingResult();
        geocodingResult.setGeocodingObjectInformation(geocodingObjectInformationList);
        assertEquals("Address", this.findValidLocationAddressService.find(geocodingResult).getFormattedAddress());
    }

}

