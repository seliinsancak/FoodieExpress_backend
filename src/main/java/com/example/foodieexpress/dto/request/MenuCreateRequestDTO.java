package com.example.foodieexpress.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MenuCreateRequestDTO(
        @NotNull
        Long restaurantId,  // hangi restorana ait olduğu bilgisi

        @NotNull
        @NotBlank
        @Size(max = 100)
        String name,  // Menü adı

        @NotNull
        @Size(max = 255)
        String description,  // açıklaması

        @NotNull
        Double price  // fiyatı
) {
}
