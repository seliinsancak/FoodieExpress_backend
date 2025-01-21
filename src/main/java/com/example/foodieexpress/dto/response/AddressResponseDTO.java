package com.example.foodieexpress.dto.response;

public record AddressResponseDTO(
        Long addressId,      // Adres ID'si
        Long userId,         // Kullanıcı ID'si
        String addressLine,  // Adres satırı
        String city,         // Şehir
        String district,     // İlçe
        String postalCode    // Posta kodu
) {
}
