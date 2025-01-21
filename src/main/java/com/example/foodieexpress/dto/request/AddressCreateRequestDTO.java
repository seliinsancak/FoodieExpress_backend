package com.example.foodieexpress.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AddressCreateRequestDTO(
        @NotNull
        Long userId,         // Kullanıcı ID'si

        @NotNull
        @Size(max = 255)
        String addressLine,  // Adres satırı

        @NotNull
        @Size(max = 100)
        String city,         // Şehir

        @NotNull
        @Size(max = 100)
        String district,     // İlçe

        @NotNull
        @Size(max = 20)
        String postalCode    // Posta kodu
) {
}
