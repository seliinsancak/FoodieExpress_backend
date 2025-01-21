package com.example.foodieexpress.repository;


import com.example.foodieexpress.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findById(Long id);

    List<Restaurant> findByNameContainingIgnoreCase(String name);

    List<Restaurant> findAllByCity(String city);

    List<Restaurant> findAllByRatingGreaterThanEqual(Double rating);
}
