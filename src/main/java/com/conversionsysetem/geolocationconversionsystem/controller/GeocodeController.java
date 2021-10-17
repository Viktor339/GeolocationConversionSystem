package com.conversionsysetem.geolocationconversionsystem.controller;

import com.conversionsysetem.geolocationconversionsystem.controller.request.GeocodingRequest;
import com.conversionsysetem.geolocationconversionsystem.service.GeocodeControllerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Tag(name = "Geocode controller", description = "Allows to perform geocoding from address to coordinates")
@RestController
@RequiredArgsConstructor
public class GeocodeController {

    private  final GeocodeControllerService geocodeControllerService;

    @Operation(summary = "Get geocoding", description = "Allows to get results of geocoding")
    @PostMapping("/geocoding")
    public ResponseEntity<?> getGeocoding(@RequestBody GeocodingRequest geocodingRequest) throws IOException {
       return ResponseEntity.ok(geocodeControllerService.getGeocoding(geocodingRequest));
    }
}
