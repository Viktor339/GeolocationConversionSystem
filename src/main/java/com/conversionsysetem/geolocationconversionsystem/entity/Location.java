package com.conversionsysetem.geolocationconversionsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    @JsonProperty("lat")
    private String latitude;
    @JsonProperty("lng")
    private String longitude;
}