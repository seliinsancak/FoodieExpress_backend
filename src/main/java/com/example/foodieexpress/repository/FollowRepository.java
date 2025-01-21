package com.example.foodieexpress.repository;

import com.example.foodieexpress.entity.Follow;
import com.example.foodieexpress.entity.Restaurant;
import com.example.foodieexpress.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {


    boolean existsByUserAndRestaurant(User user, Restaurant restaurant);


    Optional<Follow> findByUserAndRestaurant(User user, Restaurant restaurant);
}

