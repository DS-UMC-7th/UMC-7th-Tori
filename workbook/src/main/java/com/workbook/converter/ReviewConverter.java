package com.workbook.converter;

import com.workbook.domain.Review;
import com.workbook.domain.Restaurant;
import com.workbook.domain.User;
import com.workbook.web.dto.ReviewRequestDTO;
import com.workbook.web.dto.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.CreateDto request, User user, Restaurant restaurant) {
        return Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .user(user)
                .restaurant(restaurant)
                .build();
    }

    public static ReviewResponseDTO.CreateReviewResponseDTO toCreateReviewResponseDTO(Review review) {
        return ReviewResponseDTO.CreateReviewResponseDTO.builder()
                .reviewId(review.getReview_id())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static List<ReviewResponseDTO.GetReviewResponseDTO> toGetReviewResponseDTOList(List<Review> reviews) {
        return reviews.stream()
                .map(review -> ReviewResponseDTO.GetReviewResponseDTO.builder()
                        .reviewId(review.getReview_id())
                        .restaurantId(review.getRestaurant().getRestaurant_id())
                        .rating(review.getRating())
                        .content(review.getContent())
                        .createdAt(review.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }

}
