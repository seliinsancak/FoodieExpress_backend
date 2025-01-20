package com.example.foodieexpress.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    private final int code;
    private final HttpStatus status;


    public ApiException(ErrorType errorType) {
        super(errorType.getMessage());
        this.code = errorType.getCode();
        this.status = errorType.getHttpStatus();
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }
}


