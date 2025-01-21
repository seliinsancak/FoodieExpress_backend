package com.example.foodieexpress.dto.response;

public record EmailResponseDTO(String message, boolean success) {
    // Record sınıfı olduğu için getter, setter gibi metodlar otomatik olarak gelir.
}
