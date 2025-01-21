package com.example.foodieexpress.exception;

public class FoodieExpressException extends RuntimeException {

    // Hata mesajı
    private final String message;

    public FoodieExpressException(String message) {
        super(message);
        this.message = message;
    }

    // Mesajı döndürmek için
    @Override
    public String getMessage() {
        return this.message;
    }
}