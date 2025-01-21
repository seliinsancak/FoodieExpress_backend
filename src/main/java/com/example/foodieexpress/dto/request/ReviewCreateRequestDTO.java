package com.example.foodieexpress.dto.request;

import jakarta.validation.constraints.*;

public record ReviewCreateRequestDTO(
        @NotNull
        Long userId,         // Kullanıcı ID'si

        @NotNull
        Long menuItemId,     // Menü ürünü ID'si

        @NotNull
        String comment,      // Yorum

        @NotNull
        Integer rating       // Derecelendirme
) {
}