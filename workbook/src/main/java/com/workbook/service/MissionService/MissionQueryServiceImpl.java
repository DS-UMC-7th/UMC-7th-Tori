package com.workbook.service.MissionService;

import com.workbook.domain.Mission;
import com.workbook.repository.MissionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    public MissionQueryServiceImpl(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    @Override
    public Page<Mission> getMissionsByRestaurant(Long restaurantId, Integer page) {

        PageRequest pageRequest = PageRequest.of(page, 10);
        return missionRepository.findByRestaurantRestaurantId(restaurantId, pageRequest);
    }
}
