package com.example.foodieexpress.service;

import com.example.foodieexpress.dto.request.FollowRequestDTO;
import com.example.foodieexpress.dto.response.FollowResponseDTO;
import com.example.foodieexpress.entity.Follow;
import com.example.foodieexpress.entity.Restaurant;
import com.example.foodieexpress.entity.User;
import com.example.foodieexpress.exception.FoodieExpressException;
import com.example.foodieexpress.repository.FollowRepository;
import com.example.foodieexpress.repository.RestaurantRepository;
import com.example.foodieexpress.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Transactional
    public FollowResponseDTO followRestaurant(FollowRequestDTO followRequestDTO) {
        Long userId = followRequestDTO.userId();
        Long restaurantId = followRequestDTO.restaurantId();

        // Kullanıcıyı bul
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new FoodieExpressException("Kullanıcı bulunamadı."));

        // Restoranı bul
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new FoodieExpressException("Restoran bulunamadı."));

        // Kullanıcının zaten takip edip etmediğini kontrol et
        if (followRepository.existsByUserAndRestaurant(user, restaurant)) {
            throw new FoodieExpressException("Zaten bu restoranı takip ediyorsunuz.");
        }

        // Takip işlemini kaydet
        followRepository.save(new Follow(user, restaurant));

        return new FollowResponseDTO(user.getId(), restaurant.getId());
    }

    @Transactional
    public void unfollowRestaurant(FollowRequestDTO followRequestDTO) {
        Long userId = followRequestDTO.userId();
        Long restaurantId = followRequestDTO.restaurantId();

        // Kullanıcıyı bul
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new FoodieExpressException("Kullanıcı bulunamadı."));

        // Restoranı bul
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new FoodieExpressException("Restoran bulunamadı."));

        // Takip ilişkisini bul
        Follow follow = followRepository.findByUserAndRestaurant(user, restaurant)
                .orElseThrow(() -> new FoodieExpressException("Takip edilmeyen restoranı takibi kaldıramazsınız."));

        // Takibi kaldır
        followRepository.delete(follow);
    }
}
