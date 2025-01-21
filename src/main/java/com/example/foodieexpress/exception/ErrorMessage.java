package com.example.foodieexpress.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ErrorMessage {

    private int code;
    private String message;
    private boolean success;
    private List<String> fields;
}
