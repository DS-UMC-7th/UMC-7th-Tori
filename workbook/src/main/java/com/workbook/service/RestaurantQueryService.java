package com.workbook.service;

import com.workbook.domain.Restaurant;

import java.util.Optional;
import java.util.List;

public interface RestaurantQueryService {

    Optional<Restaurant> findRestaurant(Long id);
    List<Restaurant> findRestaurantsByNameAndRating(String name, Long rating);
}
