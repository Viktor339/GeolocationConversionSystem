package com.conversionsysetem.geolocationconversionsystem.service;

import com.conversionsysetem.geolocationconversionsystem.controller.request.ReverseGeocodingRequest;
import com.conversionsysetem.geolocationconversionsystem.entity.Address;
import com.conversionsysetem.geolocationconversionsystem.entity.GeocodingResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ReverseGeocodeControllerService {

    private final AddressAndCoordinatesBuilderService addressAndCoordinatesBuilderService;
    private final FindValidLocationAddressService findValidLocationAddressService;
    private final ProxySendRequestService proxySendRequestService;

    public Address getReverseGeocoding(ReverseGeocodingRequest reverseGeocodingRequest) throws IOException {

        String coordinates = addressAndCoordinatesBuilderService.buildCoordinates(reverseGeocodingRequest);
        GeocodingResult geocodingResult = proxySendRequestService.send(coordinates);

        return findValidLocationAddressService.find(geocodingResult);
    }
}
