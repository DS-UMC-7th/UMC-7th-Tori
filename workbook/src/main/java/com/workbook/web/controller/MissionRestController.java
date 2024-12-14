package com.workbook.web.controller;

import com.workbook.apiPayload.ApiResponse;
import com.workbook.converter.MissionConverter;
import com.workbook.domain.Mission;
import com.workbook.service.MissionService.MissionCommandService;
import com.workbook.web.dto.MissionRequestDTO;
import com.workbook.web.dto.MissionResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.CreateMissionResponseDTO> join(@RequestBody @Valid MissionRequestDTO.CreateMissionRequestDTO request) {
        Mission mission = missionCommandService.createMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResponseDTO(mission));
    }
}
