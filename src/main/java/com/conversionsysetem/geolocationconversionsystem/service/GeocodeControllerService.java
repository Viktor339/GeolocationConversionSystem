package com.conversionsysetem.geolocationconversionsystem.service;

import com.conversionsysetem.geolocationconversionsystem.controller.request.GeocodingRequest;
import com.conversionsysetem.geolocationconversionsystem.entity.GeocodingObjectInformation;
import com.conversionsysetem.geolocationconversionsystem.entity.GeocodingResult;
import com.conversionsysetem.geolocationconversionsystem.entity.Geometry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GeocodeControllerService {

    private final AddressAndCoordinatesBuilderService addressAndCoordinatesBuilderService;
    private final ProxySendRequestService proxySendRequestService;

    public List<Geometry> getGeocoding(GeocodingRequest geocodingRequest) throws IOException {

        String address = addressAndCoordinatesBuilderService.buildAddress(geocodingRequest);
        GeocodingResult geocodingResult = proxySendRequestService.send(address);
        List<GeocodingObjectInformation> geocodingObjectInformationList = geocodingResult.getGeocodingObjectInformation();

        return geocodingObjectInformationList
                .stream()
                .map(GeocodingObjectInformation::getGeometry)
                .collect(Collectors.toList());
    }
}
