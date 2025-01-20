package com.example.foodieexpress.service;

package com.foodieexpress.service;

import com.foodieexpress.model.Restaurant;
import com.foodieexpress.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    // Restoran kaydetme
    public Restaurant save(com.example.foodieexpress.service.Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // Tüm restoranları listeleme
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    // Restoran ID'ye göre bulma
    public Optional<Restaurant> findById(Long id) {
        return restaurantRepository.findById(id);
    }

    // Restoran adıyla arama (case-insensitive)
    public List<Restaurant> findByName(String name) {
        return restaurantRepository.findByNameContaining(name);
    }

    // Restoranı aktif etme veya pasif yapma
    public void toggleRestaurantStatus(Long id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            restaurant.setActive(!restaurant.isActive());
            restaurantRepository.save(restaurant);
        }
    }
}


