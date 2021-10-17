package com.conversionsysetem.geolocationconversionsystem.service.exception;

public class LanguageNotValidException extends RuntimeException{
    public LanguageNotValidException(String message) {
        super(message);
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
