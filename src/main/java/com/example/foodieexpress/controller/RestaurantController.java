package com.example.foodieexpress.controller;

import com.example.foodieexpress.dto.request.RestaurantCreateRequestDTO;
import com.example.foodieexpress.dto.response.RestaurantResponseDTO;
import com.example.foodieexpress.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // Yeni restoran ekleme
    @PostMapping
    public ResponseEntity<String> createRestaurant(@Valid @RequestBody RestaurantCreateRequestDTO restaurantDTO) {
        restaurantService.createRestaurant(restaurantDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Restaurant created successfully");
    }

    // Tüm restoranları listeleme
    @GetMapping
    public ResponseEntity<List<RestaurantResponseDTO>> getAllRestaurants() {
        List<RestaurantResponseDTO> restaurants = restaurantService.getAllRestaurants()
                .stream()
                .map(restaurant -> new RestaurantResponseDTO(
                        null, // ID, veritabanı entegrasyonu ile sağlanacak
                        restaurant.name(),
                        restaurant.city(),
                        restaurant.address(),
                        restaurant.rating()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(restaurants);
    }
}