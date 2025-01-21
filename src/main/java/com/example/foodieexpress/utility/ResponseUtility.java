package com.example.foodieexpress.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtility {

    // başarılı yanıt oluşturma
    public static <T> ResponseEntity<T> success(T data) {
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    // başarısız yanıt oluşturma
    public static ResponseEntity<String> error(String message, HttpStatus status) {
        return ResponseEntity.status(status).body(message);
    }
}