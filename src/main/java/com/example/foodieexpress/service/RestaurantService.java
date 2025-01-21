package com.example.foodieexpress.service;

import com.example.foodieexpress.dto.request.RestaurantCreateRequestDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    private final List<RestaurantCreateRequestDTO> restaurantList = new ArrayList<>();

    // Yeni restoran oluşturma
    public void createRestaurant(RestaurantCreateRequestDTO restaurantDTO) {
        restaurantList.add(restaurantDTO);
        // Gerçek uygulamada, restoran veritabanına kaydedilebilir
    }

    // Tüm restoranları listeleme
    public List<RestaurantCreateRequestDTO> getAllRestaurants() {
        return restaurantList;
    }
}

