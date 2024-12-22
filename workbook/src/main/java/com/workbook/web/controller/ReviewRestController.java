package com.workbook.web.controller;

import com.workbook.apiPayload.ApiResponse;
import com.workbook.converter.ReviewConverter;
import com.workbook.domain.Review;
import com.workbook.service.ReviewService.ReviewCommandService;
import com.workbook.service.ReviewService.ReviewQueryService;
import com.workbook.validation.annotation.PageValid;
import com.workbook.web.dto.ReviewRequestDTO;
import com.workbook.web.dto.ReviewResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.CreateReviewResponseDTO> createReview(@RequestBody @Valid ReviewRequestDTO.CreateDto request){
        Review review = reviewCommandService.createReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResponseDTO(review));
    }

    @GetMapping("/my-reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회", description = "사용자가 작성한 리뷰들을 페이징 처리하여 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK ,성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<List<ReviewResponseDTO.GetReviewResponseDTO>> getMyReviews(@RequestParam @PageValid Integer page) {
        // 하드코딩된 userId = 1
        Long userId = 1L;

        if (page < 1) {
            throw new IllegalArgumentException("페이지 번호는 1 이상이어야 합니다.");
        }

        Page<Review> reviews = reviewQueryService.getReviewsByUser(userId, page - 1);
        List<ReviewResponseDTO.GetReviewResponseDTO> reviewResponseDTOList = ReviewConverter.toGetReviewResponseDTOList(reviews.getContent());
        return ApiResponse.onSuccess(reviewResponseDTOList);
    }
}
