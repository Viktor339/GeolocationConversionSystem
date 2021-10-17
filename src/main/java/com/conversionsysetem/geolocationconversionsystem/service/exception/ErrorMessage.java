package com.conversionsysetem.geolocationconversionsystem.service.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class ErrorMessage {

    private final Map<String,Object> resultMessage = new LinkedHashMap<>();

    public ErrorMessage(LocalDateTime timestamp, int status, String error, String massage){
        resultMessage.put("timestamp", timestamp);
        resultMessage.put("status",status);
        resultMessage.put("error",error);
        resultMessage.put("massage",massage);
    }
    public Map<String,Object> getMessage(){
        return resultMessage;
    }
}
