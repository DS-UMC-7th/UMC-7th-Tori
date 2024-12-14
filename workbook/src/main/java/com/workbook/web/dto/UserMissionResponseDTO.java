package com.workbook.web.dto;

import com.workbook.domain.enums.MissionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserMissionResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class UserMissionStatusResponseDTO {
        private MissionStatus status;
    }
}
