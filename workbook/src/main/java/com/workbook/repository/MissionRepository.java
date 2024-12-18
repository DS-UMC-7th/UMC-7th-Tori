package com.workbook.repository;

import com.workbook.domain.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findByRestaurantRestaurantId(Long restaurantId, PageRequest pageRequest);
}
