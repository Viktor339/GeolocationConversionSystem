package com.conversionsysetem.geolocationconversionsystem.service;

import com.conversionsysetem.geolocationconversionsystem.entity.GeocodingResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class SendRequestService {

    @Value("${request.config.key}")
    private String userKey;

    @Value("${request.config.url}")
    private String url;

    @Value("${request.config.address}")
    private String address;

    public GeocodingResult send(String addressOrCoordinates) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url + addressOrCoordinates)
                .get()
                .addHeader("x-rapidapi-host", address)
                .addHeader("x-rapidapi-key", userKey)
                .build();

        ResponseBody responseBody = client.newCall(request).execute().body();
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(responseBody.string(), GeocodingResult.class);
    }
}
