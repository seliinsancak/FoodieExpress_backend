package com.example.foodieexpress.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRegisterRequestDTO(
        @NotNull
        @NotBlank
        @Size(max = 50)
        String name,          // Kullanıcı adı

        @NotNull
        @NotBlank
        @Email
        @Size(max = 100)
        String email,         // Kullanıcı e-posta adresi

        @NotNull
        @NotBlank
        @Size(min = 6, max = 20)
        String password,      // Kullanıcı şifresi

        @NotNull
        @NotBlank
        String confirmPassword // Şifreyi doğrulamak için, şifre tekrarı
) {
}