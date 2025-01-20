package com.example.foodieexpress.repository;


import com.example.foodieexpress.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrderId(Long orderId);  // Sipariş id'sine göre sipariş öğeleri

    List<OrderItem> findByMenuItemId(Long menuItemId);  // Menü öğesi id'sine göre sipariş öğeleri
}
