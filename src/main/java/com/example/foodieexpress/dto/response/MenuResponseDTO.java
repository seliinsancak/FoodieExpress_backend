package com.example.foodieexpress.dto.response;


public record MenuResponseDTO(
        Long id,               // Menü ID'si
        Long restaurantId,     // Menü hangi restorana ait
        String name,           // Menü adı
        String description,    // Menü açıklaması
        Double price           // Menü fiyatı
) {
}
