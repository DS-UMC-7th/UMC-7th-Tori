package com.workbook.service.ReviewService;

import com.workbook.domain.Review;
import com.workbook.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public ReviewQueryServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Page<Review> getReviewsByUser(Long userId, Integer page) {

        PageRequest pageRequest = PageRequest.of(page, 10);
        return reviewRepository.findAllByUserUserId(userId, pageRequest);
    }
}
