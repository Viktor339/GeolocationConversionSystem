package com.conversionsysetem.geolocationconversionsystem.controller;

import com.conversionsysetem.geolocationconversionsystem.controller.request.ReverseGeocodingRequest;
import com.conversionsysetem.geolocationconversionsystem.service.ReverseGeocodeControllerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Tag(name = "Reverse geocode controller", description = "Allows to perform reverse geocoding from coordinates to address ")
@RestController
@RequiredArgsConstructor
public class ReverseGeocodeController {

    private final ReverseGeocodeControllerService reverseGeocodeControllerService;

    @Operation(summary = "Get geocoding", description = "Allows to get results of reverse geocoding")
    @PostMapping("/reverse-geocoding")
    public ResponseEntity<?> getReverseGeocoding(@RequestBody ReverseGeocodingRequest reverseGeocodingRequest) throws IOException {
        return ResponseEntity.ok(reverseGeocodeControllerService.getReverseGeocoding(reverseGeocodingRequest));
    }
}
