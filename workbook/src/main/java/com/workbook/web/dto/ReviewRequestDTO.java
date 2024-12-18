package com.workbook.web.dto;

import com.workbook.validation.annotation.PageValid;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class CreateDto {
        Long userId;
        Long restaurantId;
        String content;
        Integer rating;
    }

    @Getter
    public static class GetReviewsRequestDTO {

        @PageValid
        Integer page;
    }
}
