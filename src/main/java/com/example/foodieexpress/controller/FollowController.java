package com.foodieexpress.controller;

import com.foodieexpress.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/follow")
    public void followRestaurant(@RequestParam Long userId, @RequestParam Long restaurantId) {
        followService.followRestaurant(userId, restaurantId);
    }

    @PostMapping("/unfollow")
    public void unfollowRestaurant(@RequestParam Long userId, @RequestParam Long restaurantId) {
        followService.unfollowRestaurant(userId, restaurantId);
    }
}

