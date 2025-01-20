package com.example.foodieexpress.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(ApiException ex) {

        return new ResponseEntity<>(new ErrorResponse(ex.getCode(), ex.getMessage()), ex.getStatus());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse(500, "Sunucu hatası"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
