package com.tinqin.zoostore.rest;

import com.tinqin.zoostore.core.exception.*;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestControllerAdvice
public class RestControllerAdviceExceptionHandlerConfiguration {

    @ExceptionHandler({
            VendorNotFoundException.class,
            TagNotFoundException.class,
            MultimediaNotFoundException.class,
            ItemNotFoundException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleItemNotFoundException(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<String> handleValidatorException(MethodArgumentNotValidException e) {

        String errors = Arrays.stream(e.getDetailMessageArguments()).toList()
                .stream()
                .flatMap(listError -> Stream.of(listError.toString()))
                .toList()
                .stream()
                .map(error -> error.replace("[", ""))
                .map(error -> error.replace("]", ""))
                .filter(error -> error.length() > 0)
                .collect(Collectors.joining(System.lineSeparator()));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class,})
    @ResponseBody
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({PageableParameterException.class,})
    @ResponseBody
    public ResponseEntity<String> handlePageableParameterException(PageableParameterException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e){
        String message = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(System.lineSeparator()));

        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }
}
