package com.example.foodieexpress.dto.response;

import com.example.foodieexpress.dto.OrderItemDTO;
import com.example.foodieexpress.dto.request.OrderItemCreateDTO;

import java.util.List;

public record OrderResponseDTO(
        Long orderId,       // Sipariş ID'si
        Long userId,        // Kullanıcı ID'si
        List<OrderItemDTO> items, // Sipariş kalemleri
        Double totalPrice,  // Toplam fiyat
        String status       // Sipariş durumu
) {
}
