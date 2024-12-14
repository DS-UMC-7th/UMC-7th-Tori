package com.workbook.converter;

import com.workbook.domain.Mission;
import com.workbook.domain.Restaurant;
import com.workbook.web.dto.MissionRequestDTO;
import com.workbook.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.CreateMissionRequestDTO request, Restaurant restaurant) {
        return Mission.builder()
                .restaurant(restaurant)
                .deadline(request.getDeadline())
                .missionCode(request.getMissionCode())
                .point(request.getPoint())
                .targetPrice(request.getTargetPrice())
                .build();
    }

    public static MissionResponseDTO.CreateMissionResponseDTO toCreateMissionResponseDTO(Mission mission){
        return MissionResponseDTO.CreateMissionResponseDTO.builder()
                .missionId(mission.getMissionId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
