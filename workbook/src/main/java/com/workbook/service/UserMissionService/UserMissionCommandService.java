package com.workbook.service.UserMissionService;

import com.workbook.web.dto.UserMissionRequestDTO;
import com.workbook.web.dto.UserMissionResponseDTO;

public interface UserMissionCommandService {

    UserMissionResponseDTO.UserMissionStatusResponseDTO updateMissionStatus(
            Long userId, Long missionId, UserMissionRequestDTO.ChallengeMissionRequestDTO request);
}
