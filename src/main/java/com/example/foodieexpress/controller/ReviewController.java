package com.example.foodieexpress.controller;

import com.example.foodieexpress.dto.request.ReviewCreateRequestDTO;
import com.example.foodieexpress.dto.response.RatingResponseDTO;
import com.example.foodieexpress.dto.response.ReviewResponseDTO;
import com.example.foodieexpress.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/add")
    public ResponseEntity<ReviewResponseDTO> addReview(@RequestBody ReviewCreateRequestDTO reviewDTO) {
        ReviewResponseDTO reviewResponse = reviewService.addReview(reviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewResponse);
    }

    @GetMapping("/product/{menuItemId}")
    public ResponseEntity<RatingResponseDTO> getProductRating(@PathVariable Long menuItemId) {
        RatingResponseDTO ratingResponse = reviewService.getProductRating(menuItemId);
        return ResponseEntity.ok(ratingResponse);
    }

    @GetMapping("/product/{menuItemId}/reviews")
    public ResponseEntity<List<ReviewResponseDTO>> getReviewsByMenuItem(@PathVariable Long menuItemId) {
        List<ReviewResponseDTO> reviews = reviewService.getReviewsByMenuItem(menuItemId);
        return ResponseEntity.ok(reviews);
    }
}