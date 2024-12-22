package com.workbook.web.dto;

import lombok.Getter;
import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class CreateMissionRequestDTO{
        Long restaurantId;
        LocalDate deadline;
        String missionCode;
        Integer point;
        Integer targetPrice;
    }
}
