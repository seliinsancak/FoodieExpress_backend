package com.example.foodieexpress.exception;

import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;


public enum ErrorType {

    INTERNAL_SERVER_ERROR(500, "Sunucuda beklenmeyen bir hata oldu.", HttpStatus.INTERNAL_SERVER_ERROR),
    VALIDATION_ERROR(400, "Girilen parametreler hatalıdır.", HttpStatus.BAD_REQUEST),
    PAGE_NOT_FOUND(404, "Sayfa bulunamadı.", HttpStatus.NOT_FOUND),
    USER_NOT_FOUND(1001, "Kullanıcı bulunamadı.", HttpStatus.NOT_FOUND),
    USER_ALREADY_EXISTS(1002, "Kullanıcı zaten mevcut.", HttpStatus.BAD_REQUEST),
    USER_UNAUTHORIZED(1003, "Bu işlem için yetkiniz yok.", HttpStatus.FORBIDDEN),
    INVALID_CREDENTIALS(1004, "Geçersiz kullanıcı adı veya şifre.", HttpStatus.UNAUTHORIZED),
    USER_LOCKED(1005, "Hesap kilitli, lütfen destek ile iletişime geçin.", HttpStatus.FORBIDDEN),
    ORDER_NOT_FOUND(2001, "Sipariş bulunamadı.", HttpStatus.NOT_FOUND),
    ORDER_ALREADY_EXISTS(2002, "Bu sipariş zaten mevcut.", HttpStatus.BAD_REQUEST),
    ORDER_INVALID_STATUS(2003, "Sipariş durumu geçersiz.", HttpStatus.BAD_REQUEST),
    RESTAURANT_NOT_FOUND(3001, "Restoran bulunamadı.", HttpStatus.NOT_FOUND),
    RESTAURANT_ALREADY_EXISTS(3002, "Restoran zaten mevcut.", HttpStatus.BAD_REQUEST),
    RESTAURANT_CLOSED(3003, "Restoran kapalı, şu an sipariş verilemez.", HttpStatus.BAD_REQUEST),
    MENU_NOT_FOUND(4001, "Menü bulunamadı.", HttpStatus.NOT_FOUND),
    MENU_ALREADY_EXISTS(4002, "Menü zaten mevcut.", HttpStatus.BAD_REQUEST),
    MENU_ITEM_NOT_FOUND(4003, "Menü öğesi bulunamadı.", HttpStatus.NOT_FOUND),
    MENU_ITEM_OUT_OF_STOCK(4004, "Menü öğesi tükenmiş.", HttpStatus.BAD_REQUEST),
    REVIEW_NOT_FOUND(5001, "Yorum bulunamadı.", HttpStatus.NOT_FOUND),
    REVIEW_ALREADY_EXISTS(5002, "Yorum zaten yapılmış.", HttpStatus.BAD_REQUEST),
    REVIEW_INVALID_RATING(5003, "Geçersiz puanlama.", HttpStatus.BAD_REQUEST),
    PAYMENT_FAILED(6001, "Ödeme işlemi başarısız.", HttpStatus.BAD_REQUEST),
    PAYMENT_METHOD_NOT_SUPPORTED(6002, "Ödeme yöntemi desteklenmiyor.", HttpStatus.BAD_REQUEST),
    UNEXPECTED_ERROR(9999, "Beklenmeyen bir hata oluştu.", HttpStatus.INTERNAL_SERVER_ERROR);

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

    public ErrorMessage toErrorMessage() {
        return ErrorMessage.builder()
                .code(this.code)
                .message(this.message)
                .success(false)
                .fields(null)  // You can customize this as needed
                .build();
    }
}



