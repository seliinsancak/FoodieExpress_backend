package com.example.foodieexpress.repository;


import com.example.foodieexpress.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findById(Long id);  // Restoran id'sine göre bul

    List<Restaurant> findByNameContainingIgnoreCase(String name);  // Restoran ismine göre arama (case insensitive)

    List<Restaurant> findAllByCity(String city);  // Şehre göre restoranları listele

    List<Restaurant> findAllByRatingGreaterThanEqual(Double rating);  // Yüksek puanlı restoranları listele
}
