package com.example.foodieexpress.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    private Integer code;
    private String message;
    private boolean success;
    private Object fields;
}


