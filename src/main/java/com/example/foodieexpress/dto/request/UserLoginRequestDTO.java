package com.example.foodieexpress.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserLoginRequestDTO(
        @NotNull
        @NotBlank
        @Email
        @Size(max = 100)
        String email,         // Kullanıcı e-posta adresi

        @NotNull
        @NotBlank
        @Size(min = 6, max = 20)
        String password       // Kullanıcı şifresi
) {
}