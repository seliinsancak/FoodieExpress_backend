package com.example.foodieexpress.repository;

import com.example.foodieexpress.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Long userId);  // Kullanıcı id'sine göre siparişler

    List<Order> findByRestaurantId(Long restaurantId);  // Restoran id'sine göre siparişler

    List<Order> findByStatus(String status);  // Sipariş durumu ile siparişler

    List<Order> findByRestaurantIdAndStatus(Long restaurantId, String status);  // Restoran ve sipariş durumu ile siparişler
}
