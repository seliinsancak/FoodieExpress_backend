package com.example.foodieexpress.service;

import com.example.foodieexpress.dto.request.ReviewCreateRequestDTO;
import com.example.foodieexpress.dto.response.RatingResponseDTO;
import com.example.foodieexpress.dto.response.ReviewResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    private final List<ReviewResponseDTO> reviews = new ArrayList<>();

    // Yorum ve değerlendirme ekleme
    public ReviewResponseDTO addReview(ReviewCreateRequestDTO reviewDTO) {
        ReviewResponseDTO reviewResponseDTO = new ReviewResponseDTO(
                (long) (reviews.size() + 1),
                reviewDTO.userId(),
                reviewDTO.menuItemId(),
                reviewDTO.comment(),
                reviewDTO.rating()
        );
        reviews.add(reviewResponseDTO);
        return reviewResponseDTO;
    }

    // Ürün bazında ortalama değerlendirme
    public RatingResponseDTO getProductRating(Long menuItemId) {
        double totalRating = 0;
        int count = 0;
        for (ReviewResponseDTO review : reviews) {
            if (review.menuItemId().equals(menuItemId)) {
                totalRating += review.rating();
                count++;
            }
        }
        double averageRating = count > 0 ? totalRating / count : 0;
        return new RatingResponseDTO(menuItemId, averageRating);
    }

    // Kullanıcı yorumlarını almak
    public List<ReviewResponseDTO> getReviewsByMenuItem(Long menuItemId) {
        List<ReviewResponseDTO> menuItemReviews = new ArrayList<>();
        for (ReviewResponseDTO review : reviews) {
            if (review.menuItemId().equals(menuItemId)) {
                menuItemReviews.add(review);
            }
        }
        return menuItemReviews;
    }
}
