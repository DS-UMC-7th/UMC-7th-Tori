package com.workbook.service.ReviewService;

import com.workbook.converter.ReviewConverter;
import com.workbook.domain.Review;
import com.workbook.domain.Restaurant;
import com.workbook.domain.User;
import com.workbook.repository.RestaurantRepository.RestaurantRepository;
import com.workbook.repository.UserRepository;
import com.workbook.repository.ReviewRepository;
import com.workbook.web.dto.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public Review createReview(ReviewRequestDTO.CreateDto request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Review review = ReviewConverter.toReview(request, user, restaurant);

        return reviewRepository.save(review);
    }
}
