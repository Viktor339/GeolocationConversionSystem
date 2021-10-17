package com.conversionsysetem.geolocationconversionsystem.service.exception;

public class LongitudeNotValidException extends RuntimeException{
    public LongitudeNotValidException(String message) {
        super(message);
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
