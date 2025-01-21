package com.example.foodieexpress.dto.response;

public record FollowResponseDTO(
        Long userId,  // Takip eden kullanıcı ID'si
        Long restaurantId  // Takip edilen restoran ID'si
) {

}