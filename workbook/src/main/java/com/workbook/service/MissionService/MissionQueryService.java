package com.workbook.service.MissionService;

import com.workbook.domain.Mission;
import org.springframework.data.domain.Page;

public interface MissionQueryService {
    Page<Mission> getMissionsByRestaurant(Long restaurantId, Integer page);
}
