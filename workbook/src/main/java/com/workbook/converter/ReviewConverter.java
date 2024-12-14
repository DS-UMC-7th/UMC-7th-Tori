package com.workbook.converter;

import com.workbook.domain.Review;
import com.workbook.domain.Restaurant;
import com.workbook.domain.User;
import com.workbook.web.dto.ReviewRequestDTO;
import com.workbook.web.dto.ReviewResponseDTO;

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

}
