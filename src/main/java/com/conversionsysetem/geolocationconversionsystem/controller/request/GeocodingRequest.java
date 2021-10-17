package com.conversionsysetem.geolocationconversionsystem.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeocodingRequest {
    @Schema(description = "city", example = "San Francisco")
    private String city;
    @Schema(description = "street", example = "Townsend St.")
    private String street;
    @Schema(description = "house", example = "164")
    private String house;
}
