package com.workbook.repository;

import com.workbook.domain.Restaurant;
import com.workbook.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);
    Page<Review> findAllByUserUserId(Long userId, Pageable pageable);
}
