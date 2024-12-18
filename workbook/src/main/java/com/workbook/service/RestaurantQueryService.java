package com.workbook.service;

import com.workbook.domain.Restaurant;
import com.workbook.domain.Review;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.List;

public interface RestaurantQueryService {

    Optional<Restaurant> findRestaurant(Long id);
    List<Restaurant> findRestaurantsByNameAndRating(String name, Long rating);
    Page<Review> getReviewList(Long RestaurantId, Integer page);
}
