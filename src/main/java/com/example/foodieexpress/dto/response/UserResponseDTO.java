package com.example.foodieexpress.dto.response;

public record UserResponseDTO(
        Long id,               // Kullanıcı ID'si
        String name,           // Kullanıcı adı
        String email           // Kullanıcı e-posta adresi
) {
}