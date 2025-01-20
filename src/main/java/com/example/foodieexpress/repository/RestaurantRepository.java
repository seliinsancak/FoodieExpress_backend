package com.example.foodieexpress.repository;

import com.example.foodieexpress.entity.enums.RestaurantType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository<Restaurant> extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByType(RestaurantType type);

    List<Restaurant> findByNameContainingIgnoreCase(String name);
}
