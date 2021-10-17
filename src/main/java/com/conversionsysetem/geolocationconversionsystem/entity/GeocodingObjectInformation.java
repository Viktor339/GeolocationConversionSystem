package com.conversionsysetem.geolocationconversionsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodingObjectInformation {

    @JsonProperty("formatted_address")
    private String formattedAddress;
    @JsonProperty("geometry")
    private Geometry geometry;

    public Address getFormattedAddress() {
        return new Address(formattedAddress);
    }

    public Geometry getGeometry() {
        return geometry;
    }
}
