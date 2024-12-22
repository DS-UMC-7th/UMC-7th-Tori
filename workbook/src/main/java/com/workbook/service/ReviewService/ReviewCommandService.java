package com.workbook.service.ReviewService;

import com.workbook.domain.Review;
import com.workbook.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    Review createReview(ReviewRequestDTO.CreateDto request);

}
