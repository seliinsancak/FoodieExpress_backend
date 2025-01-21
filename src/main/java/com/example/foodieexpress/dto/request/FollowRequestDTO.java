package com.example.foodieexpress.dto.request;

import jakarta.validation.constraints.NotNull;

public record FollowRequestDTO(
        @NotNull Long userId,
        @NotNull Long restaurantId
) {

}