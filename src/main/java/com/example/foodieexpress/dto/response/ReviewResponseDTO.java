package com.example.foodieexpress.dto.response;

public record ReviewResponseDTO(
        Long reviewId,      // Yorum ID'si
        Long userId,        // Kullanıcı ID'si
        Long menuItemId,    // Menü ürünü ID'si
        String comment,     // Yorum metni
        Integer rating      // Derecelendirme
) {
}
