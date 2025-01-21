package com.example.foodieexpress.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorUtility {

    // hata mesajı ile birlikte özel bir yanıt döndürme
    public static ResponseEntity<String> handleError(String message, HttpStatus status) {
        return ResponseUtility.error(message, status);
    }

    // hata mesajı ve exception ile döndürme
    public static ResponseEntity<String> handleException(Exception e, HttpStatus status) {
        return ResponseUtility.error(e.getMessage(), status);
    }
}
