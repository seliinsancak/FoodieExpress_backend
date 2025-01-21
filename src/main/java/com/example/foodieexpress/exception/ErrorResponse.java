package com.example.foodieexpress.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private int code;
    private String message;
    private boolean success;
    private List<String> fields;


    public static ErrorResponse from(ErrorType errorType) {
        return ErrorResponse.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .success(false)
                .fields(null)
                .build();
    }
}

