package com.workbook.repository.RestaurantRepository;

import com.workbook.domain.Restaurant;

import java.util.List;

public interface RestaurantRepositoryCustom {
    List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Long rating);
}
