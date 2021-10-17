package com.conversionsysetem.geolocationconversionsystem.service;

import com.conversionsysetem.geolocationconversionsystem.entity.Address;
import com.conversionsysetem.geolocationconversionsystem.entity.GeocodingObjectInformation;
import com.conversionsysetem.geolocationconversionsystem.entity.GeocodingResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class FindValidLocationAddressService {

    public Address find(GeocodingResult geocodingResult) {

        List<GeocodingObjectInformation> geocodingObjectInformationList = geocodingResult.getGeocodingObjectInformation();

        List<Address> allFindLocationsAddress = geocodingObjectInformationList
                .stream()
                .map(GeocodingObjectInformation::getFormattedAddress)
                .collect(Collectors.toList());

        //trying to find only "valid" address for the pattern "Street House Number, City, Country"
        //because the Google Maps API returns results that may contain or not index, house number, city index and others
        List<Address> filteredLocationsAddressList = allFindLocationsAddress
                .stream()
                .filter(address -> Pattern.matches("[A-Z].+\\s\\d(,)\\s.+(,)\\s.+", address.getFormattedAddress()))
                .collect(Collectors.toList());

        //if filteredLocationsAddress.size() > 0 -> return any address from filteredLocationsAddressList
        //else -> return any address from allFindLocationsAddress
        Address returnedAddress = allFindLocationsAddress.get(0);

        if (filteredLocationsAddressList.size() > 0) {
            returnedAddress = filteredLocationsAddressList.get(0);
        }

        return returnedAddress;
    }
}
