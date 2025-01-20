package com.example.foodieexpress.repository;

import com.example.foodieexpress.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByUserId(Long userId);

    List<Review> findByMenuItemId(Long menuItemId);

    List<Review> findByRestaurantId(Long restaurantId);
}
