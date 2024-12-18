package com.workbook.service.ReviewService;

import com.workbook.domain.Review;
import org.springframework.data.domain.Page;

public interface ReviewQueryService {

    Page<Review> getReviewsByUser(Long userId, Integer page);
}
