package com.example.foodieexpress.controller;

import com.example.foodieexpress.dto.request.FollowRequestDTO;
import com.example.foodieexpress.dto.response.FollowResponseDTO;
import com.foodieexpress.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    // Restoranı takip etme
    @PostMapping("/follow")
    public FollowResponseDTO followRestaurant(@RequestBody FollowRequestDTO followRequestDTO) {
        return followService.followRestaurant(followRequestDTO);
    }

    // Restoranı takipten çıkarma
    @PostMapping("/unfollow")
    public void unfollowRestaurant(@RequestBody FollowRequestDTO followRequestDTO) {
        followService.unfollowRestaurant(followRequestDTO);
    }
}

