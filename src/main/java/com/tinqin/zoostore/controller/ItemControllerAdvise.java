package com.tinqin.zoostore.controller;

import com.tinqin.zoostore.exception.IdNotFoundException;
import com.tinqin.zoostore.exception.VendorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ItemControllerAdvise {

    @ExceptionHandler({IdNotFoundException.class,
            VendorNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleItemNotFoundException(IdNotFoundException e) {
        return e.getMessage();
    }
}
