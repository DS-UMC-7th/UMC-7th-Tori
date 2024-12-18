package com.workbook.converter;

import com.workbook.domain.Mission;
import com.workbook.domain.Restaurant;
import com.workbook.web.dto.MissionRequestDTO;
import com.workbook.web.dto.MissionResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.MissionDTO toMissionDTO(Mission mission) {
        return MissionResponseDTO.MissionDTO.builder()
                .missionId(mission.getMissionId())
                .deadline(mission.getDeadline())
                .targetPrice(mission.getTargetPrice())
                .point(mission.getPoint())
                .missionCode(mission.getMissionCode())
                .build();
    }

    public static List<MissionResponseDTO.MissionDTO> toMissionDTOList(List<Mission> missions) {
        return missions.stream()
                .map(mission -> MissionResponseDTO.MissionDTO.builder() // 직접 builder를 사용하여 변환
                        .missionId(mission.getMissionId())
                        .deadline(mission.getDeadline())
                        .targetPrice(mission.getTargetPrice())
                        .point(mission.getPoint())
                        .missionCode(mission.getMissionCode())
                        .build())
                .collect(Collectors.toList());
    }

    public static MissionResponseDTO.MissionListResponseDTO toMissionListResponseDTO(Page<Mission> missionPage) {
        List<MissionResponseDTO.MissionDTO> missions = missionPage.getContent().stream()
                .map(mission -> MissionResponseDTO.MissionDTO.builder()
                        .missionId(mission.getMissionId())
                        .deadline(mission.getDeadline())
                        .targetPrice(mission.getTargetPrice())
                        .point(mission.getPoint())
                        .missionCode(mission.getMissionCode())
                        .build())
                .collect(Collectors.toList());

        return MissionResponseDTO.MissionListResponseDTO.builder()
                .missions(missions)
                .totalElements(missionPage.getTotalElements())
                .totalPages(missionPage.getTotalPages())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();
    }
}
