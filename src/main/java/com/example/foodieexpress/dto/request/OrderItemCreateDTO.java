package com.example.foodieexpress.dto.request;

import jakarta.validation.constraints.NotNull;

public record OrderItemCreateDTO(
        @NotNull
        Long menuItemId,    // Menüdeki ürün ID'si

        @NotNull
        Integer quantity    // Ürün adedi
) {
}