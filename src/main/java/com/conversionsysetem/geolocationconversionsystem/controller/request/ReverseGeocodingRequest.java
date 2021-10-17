package com.conversionsysetem.geolocationconversionsystem.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReverseGeocodingRequest {
    @Schema(description = "latitude", example = "55.73367")
    private Double latitude;
    @Schema(description = "longitude", example = "37.587874")
    private Double longitude;
    @Schema(description = "language", example = "en")
    private String language;
}
