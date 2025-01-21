package com.example.foodieexpress.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmailRequestDTO(
        @NotNull
        @NotBlank
        @Email
        String email
) {
    // Record sınıflarında zaten getter metodu otomatik olarak gelir.
    // Bu yüzden ekstra getEmail() metoduna gerek yoktur.
}