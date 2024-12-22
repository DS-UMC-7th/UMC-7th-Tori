package com.workbook.converter;

import com.workbook.domain.mapping.UserMission;
import com.workbook.web.dto.UserMissionResponseDTO;

public class UserMissionConverter {

    public static UserMissionResponseDTO.UserMissionStatusResponseDTO toUserMissionStatusResponseDTO(UserMission userMission) {
        return new UserMissionResponseDTO.UserMissionStatusResponseDTO(userMission.getStatus());
    }
}
