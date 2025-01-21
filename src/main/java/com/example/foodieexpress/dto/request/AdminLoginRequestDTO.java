package com.example.foodieexpress.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AdminLoginRequestDTO(
        @NotNull
        @NotBlank
        @Email
        String email,

        @NotNull
        @NotBlank
        String password
) {
}
