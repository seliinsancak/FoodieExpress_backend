package com.example.foodieexpress.dto.response;

public record RestaurantResponseDTO(
        Long id,               // Restoran ID'si
        String name,           // Restoran adı
        String city,           // Şehir
        String address,        // Restoran adresi
        Double rating          // Restoran puanı
) {
}