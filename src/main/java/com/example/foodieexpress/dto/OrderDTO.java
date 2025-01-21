package com.example.foodieexpress.dto;


public record OrderDTO(Long id, Long userId, Long restaurantId, String orderStatus, Double totalPrice, String orderDate) {
}
