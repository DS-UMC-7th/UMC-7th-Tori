package com.workbook.web.dto;

import com.workbook.domain.enums.MissionStatus;
import lombok.Getter;
import lombok.Setter;

public class UserMissionRequestDTO {

    @Getter
    @Setter
    public static class ChallengeMissionRequestDTO {
        private MissionStatus status;
    }
}
