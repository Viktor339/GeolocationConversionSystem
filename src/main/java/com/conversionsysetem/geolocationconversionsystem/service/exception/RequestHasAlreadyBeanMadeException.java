package com.conversionsysetem.geolocationconversionsystem.service.exception;

public class RequestHasAlreadyBeanMadeException extends RuntimeException{
    public RequestHasAlreadyBeanMadeException(String message) {
        super(message);
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
