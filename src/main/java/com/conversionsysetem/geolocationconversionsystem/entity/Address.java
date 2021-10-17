package com.conversionsysetem.geolocationconversionsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    private String formattedAddress;

    public Address(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }
}
