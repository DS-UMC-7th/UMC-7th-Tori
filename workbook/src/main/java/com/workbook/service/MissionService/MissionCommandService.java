package com.workbook.service.MissionService;

import com.workbook.domain.Mission;
import com.workbook.web.dto.MissionRequestDTO;

public interface MissionCommandService {

    Mission createMission(MissionRequestDTO.CreateMissionRequestDTO requestDTO);
}
