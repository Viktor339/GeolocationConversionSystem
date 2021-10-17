package com.conversionsysetem.geolocationconversionsystem.service;

import com.conversionsysetem.geolocationconversionsystem.controller.request.GeocodingRequest;
import com.conversionsysetem.geolocationconversionsystem.controller.request.ReverseGeocodingRequest;
import com.conversionsysetem.geolocationconversionsystem.service.exception.BadRequestException;
import com.conversionsysetem.geolocationconversionsystem.service.exception.LanguageNotValidException;
import com.conversionsysetem.geolocationconversionsystem.service.exception.LatitudeNotValidException;
import com.conversionsysetem.geolocationconversionsystem.service.exception.LongitudeNotValidException;
import org.springframework.stereotype.Service;

@Service
public class AddressAndCoordinatesBuilderService {

    public String buildAddress(GeocodingRequest geocodingRequest) {

        String city = geocodingRequest.getCity();
        String street = geocodingRequest.getStreet();
        String house = geocodingRequest.getHouse();

        if (city == null || street == null || house == null) {
            throw new BadRequestException("Request must contain fields: city,street,house");
        }

        return ("language=en" +
                "&address=" +
                house.trim() +
                street.trim() +
                city.trim()).replaceAll("\\s+", "");
    }


    public String buildCoordinates(ReverseGeocodingRequest reverseGeocodingRequest) {

        Double latitude = reverseGeocodingRequest.getLatitude();
        Double longitude = reverseGeocodingRequest.getLongitude();
        String language = reverseGeocodingRequest.getLanguage();


        if (latitude == null | longitude == null | language == null) {
            throw new BadRequestException("Request must contain fields: latitude,longitude,language");
        }

        if (!language.equals("ru") & !language.equals("en")) {
            throw new LanguageNotValidException("Language not valid. Please select en or ru ");
        }

        if (latitude > 90.0 | latitude < -90.0) {
            throw new LatitudeNotValidException("Latitude out of tolerance (-90;+90)");
        }

        if (longitude > 180.0 | longitude < -180.0) {
            throw new LongitudeNotValidException("Longitude out of tolerance (-180;+180");
        }

        return ("latlng=" +
                latitude +
                "%2C" +
                longitude +
                "&language=" +
                language).replaceAll("\\s+", "");
    }
}
