package com.conversionsysetem.geolocationconversionsystem.service.exception;

public class LatitudeNotValidException extends RuntimeException{
    public LatitudeNotValidException(String message) {
        super(message);
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
