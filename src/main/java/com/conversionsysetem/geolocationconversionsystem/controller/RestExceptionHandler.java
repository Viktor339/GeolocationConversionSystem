package com.conversionsysetem.geolocationconversionsystem.controller;

import com.conversionsysetem.geolocationconversionsystem.service.exception.*;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.Map;


@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(LanguageNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, Object> handleLanguageNotValidException(LanguageNotValidException ex) {

        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.name(),
                ex.getMessage()
        );
        return errorMessage.getMessage();
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleBadRequestException(BadRequestException ex) {

        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                ex.getMessage()
        );
        return errorMessage.getMessage();
    }

    @ExceptionHandler(RequestHasAlreadyBeanMadeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, Object> handleRequestHasAlreadyBeanMadeException(RequestHasAlreadyBeanMadeException ex) {

        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.name(),
                ex.getMessage()
        );
        return errorMessage.getMessage();
    }

    @ExceptionHandler(LatitudeNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, Object> handleLatitudeNotValidException(LatitudeNotValidException ex) {

        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.name(),
                ex.getMessage()
        );
        return errorMessage.getMessage();
    }

    @ExceptionHandler(LongitudeNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, Object> handleLongitudeNotValidException(LongitudeNotValidException ex) {

        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.name(),
                ex.getMessage()
        );
        return errorMessage.getMessage();
    }
}
