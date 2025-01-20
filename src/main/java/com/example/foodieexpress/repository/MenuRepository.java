package com.example.foodieexpress.repository;


import com.example.foodieexpress.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByRestaurantId(Long restaurantId);  // Restoran id'sine göre menü listele

    Menu findByIdAndRestaurantId(Long id, Long restaurantId);  // Restoran id'sine göre menü öğesini bul
}
