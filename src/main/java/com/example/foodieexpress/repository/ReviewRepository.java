package com.example.foodieexpress.repository;



import com.example.foodieexpress.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByRestaurantId(Long restaurantId);  // Restoran id'sine göre yorumlar

    List<Review> findByUserId(Long userId);  // Kullanıcı id'sine göre yorumlar

    List<Review> findByRestaurantIdAndRatingGreaterThanEqual(Long restaurantId, Double rating);  // Yüksek puanlı yorumları getir
}

