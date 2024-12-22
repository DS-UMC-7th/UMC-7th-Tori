package com.workbook.converter;

import com.workbook.domain.FoodCategory;
import com.workbook.domain.mapping.UserFoodCategory;

import java.util.List;
import java.util.stream.Collectors;


public class UserFoodCategoryConverter {

    public static List<UserFoodCategory> toUserFoodCategoryList(List<FoodCategory> foodCategoryList) {

        return foodCategoryList.stream()
                .map(foodCategory ->
                        UserFoodCategory.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}