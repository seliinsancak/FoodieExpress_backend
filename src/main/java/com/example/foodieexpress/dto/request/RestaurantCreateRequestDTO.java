package com.example.foodieexpress.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RestaurantCreateRequestDTO(
        @NotNull
        @NotBlank
        @Size(max = 100)
        String name,

        @NotNull
        @NotBlank
        @Size(max = 50)
        String city,

        @NotNull
        @NotBlank
        @Size(max = 255)
        String address,

        @NotNull
        Double rating
) {
}