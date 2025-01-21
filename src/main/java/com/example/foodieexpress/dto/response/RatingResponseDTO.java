package com.example.foodieexpress.dto.response;

public record RatingResponseDTO(
        Long menuItemId,    // Menü ürünü ID'si
        Double averageRating // Ortalama derecelendirme
) {
}