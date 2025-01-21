package com.example.foodieexpress.dto;

public record OrderItemDTO(
        Long menuItemId,    // Menü ürün ID'si
        Integer quantity,   // Ürün adedi
        Double unitPrice    // Birim fiyat
) {
}
