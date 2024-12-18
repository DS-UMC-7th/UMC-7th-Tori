package com.workbook.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMissionResponseDTO{
        Long missionId;
        LocalDateTime createdAt;

    }

    @Builder
    @Getter
    @AllArgsConstructor
    public static class MissionDTO {
        private Long missionId;
        private LocalDate deadline;
        private Integer targetPrice;
        private Integer point;
        private String missionCode;
    }

    @Builder
    @Getter
    @AllArgsConstructor
    public static class MissionListResponseDTO {
        private Long totalElements;
        private Integer totalPages;
        private Boolean isFirst;
        private Boolean isLast;
        private List<MissionDTO> missions;
    }
}
