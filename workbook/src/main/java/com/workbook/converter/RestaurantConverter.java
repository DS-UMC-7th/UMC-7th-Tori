package com.workbook.converter;

import com.workbook.domain.Review;
import com.workbook.web.dto.RestaurantResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantConverter {

    public static RestaurantResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review) {
        return RestaurantResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt().toLocalDate())
                .content(review.getContent())
                .build();
    }
    public static RestaurantResponseDTO.ReviewPreViewListDTO  reviewPreViewListDTO(Page<Review> reviewList) {

        List<RestaurantResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(RestaurantConverter::reviewPreViewDTO).collect(Collectors.toList());

        return RestaurantResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
