package com.example.foodieexpress.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

    private final ErrorType errorType;

    public ApiException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public ApiException(ErrorType errorType, String customMessage) {
        super(customMessage);
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }
}

