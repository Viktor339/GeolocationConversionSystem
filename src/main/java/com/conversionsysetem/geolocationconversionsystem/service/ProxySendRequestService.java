package com.conversionsysetem.geolocationconversionsystem.service;

import com.conversionsysetem.geolocationconversionsystem.entity.GeocodingResult;
import com.conversionsysetem.geolocationconversionsystem.service.exception.RequestHasAlreadyBeanMadeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProxySendRequestService {

    public static final List<String> executedRequestList = new ArrayList<>();
    private final SendRequestService sendRequestService;

    public GeocodingResult send(String addressOrCoordinates) throws IOException {

        if (executedRequestList.contains(addressOrCoordinates)) {
            throw new RequestHasAlreadyBeanMadeException("A request with such parameters has already been executed");
        }
        executedRequestList.add(addressOrCoordinates);
        return sendRequestService.send(addressOrCoordinates);
    }
}
