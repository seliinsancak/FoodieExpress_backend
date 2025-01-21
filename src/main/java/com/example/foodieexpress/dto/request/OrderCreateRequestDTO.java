package com.example.foodieexpress.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderCreateRequestDTO(
        @NotNull
        Long userId,         // Kullanıcı ID'si

        @NotNull
        List<OrderItemCreateDTO> items, // Sipariş kalemleri (ürünler)

        @NotNull
        Double totalPrice   // Toplam sipariş tutarı
) {
}
