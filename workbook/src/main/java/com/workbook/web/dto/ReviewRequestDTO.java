package com.workbook.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class CreateDto{
        Long userId;
        Long restaurantId;
        String content;
        Integer rating;
    }
}
