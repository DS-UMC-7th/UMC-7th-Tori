package com.workbook.service.MissionService;

import com.workbook.converter.MissionConverter;
import com.workbook.domain.Mission;
import com.workbook.domain.Restaurant;
import com.workbook.repository.MissionRepository;
import com.workbook.repository.RestaurantRepository.RestaurantRepository;
import com.workbook.web.dto.MissionRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public Mission createMission(MissionRequestDTO.CreateMissionRequestDTO request) {
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Mission mission = MissionConverter.toMission(request, restaurant);

        return missionRepository.save(mission);
    }
}
