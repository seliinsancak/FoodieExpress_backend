package com.example.foodieexpress.exception;

import org.springframework.http.HttpStatus;

public enum ErrorType {
    INTERNAL_SERVER_ERROR(500, "Sunucuda beklenmeyen bir hata oldu.", HttpStatus.INTERNAL_SERVER_ERROR),
    VALIDATION_ERROR(400, "Girilen parametreler hatalıdır.", HttpStatus.BAD_REQUEST),
    PAGE_NOT_FOUND(404, "Sayfa bulunamadı", HttpStatus.NOT_FOUND),
    USER_NOTFOUND(5001, "Kullanıcı Bulunamadı!", HttpStatus.NOT_FOUND),
    UNAUTHORIZED(5003, "Bu işlem için yetkiniz yok!", HttpStatus.FORBIDDEN);

    private final int code;
    private final String message;
    private final HttpStatus httpStatus;

    ErrorType(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
