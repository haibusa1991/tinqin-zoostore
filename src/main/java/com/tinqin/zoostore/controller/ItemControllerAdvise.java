package com.tinqin.zoostore.controller;

import com.tinqin.zoostore.exception.ItemNotFoundException;
import com.tinqin.zoostore.exception.VendorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ItemControllerAdvise {

    @ExceptionHandler({ItemNotFoundException.class,VendorNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleItemNotFoundException(ItemNotFoundException e) {
        return e.getMessage();
    }
}
