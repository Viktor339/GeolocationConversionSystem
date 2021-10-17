package com.conversionsysetem.geolocationconversionsystem.service;

import com.conversionsysetem.geolocationconversionsystem.entity.GeocodingResult;
import com.conversionsysetem.geolocationconversionsystem.service.exception.RequestHasAlreadyBeanMadeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {ProxySendRequestService.class, SendRequestService.class})
@ExtendWith(SpringExtension.class)
class ProxySendRequestServiceTest {
    @Autowired
    private ProxySendRequestService proxySendRequestService;

    @MockBean
    private SendRequestService sendRequestService;

    @Test
    void testSend_ShouldReturnGeocodingResult() throws IOException {

        String address = "address";

        GeocodingResult geocodingResult = new GeocodingResult();
        geocodingResult.setGeocodingObjectInformation(new ArrayList<>());

        List<String> executedRequestList = new ArrayList<>();
        executedRequestList.add(address);
        Assertions.assertEquals(executedRequestList.get(0), address);
        when(this.sendRequestService.send(address)).thenReturn(geocodingResult);

        Assertions.assertEquals(geocodingResult,
                this.proxySendRequestService.send(address));
    }

    @Test
    void testSend_ShouldReturnRequestHasAlreadyBeanMadeException() throws RequestHasAlreadyBeanMadeException, IOException {

        String address = "address";
        ProxySendRequestService.executedRequestList.add(address);
        assertThrows(RequestHasAlreadyBeanMadeException.class, () -> proxySendRequestService.send(address));
    }
}

