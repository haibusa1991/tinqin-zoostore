package com.tinqin.zoostore.rest;

import com.tinqin.zoostore.core.exception.InvalidUuidException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerAdviceExceptionHandlerConfiguration {

    @ExceptionHandler({
            VendorNotFoundException.class,
            InvalidUuidException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleItemNotFoundException(Exception e) {
        return e.getMessage();
    }
}
