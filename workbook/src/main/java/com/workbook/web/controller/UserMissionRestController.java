package com.workbook.web.controller;

import com.workbook.apiPayload.ApiResponse;
import com.workbook.service.UserMissionService.UserMissionCommandService;
import com.workbook.web.dto.UserMissionRequestDTO;
import com.workbook.web.dto.UserMissionResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-missions")
public class UserMissionRestController {

    private final UserMissionCommandService userMissionCommandService;

    @PatchMapping("/{missionId}/users/{userId}")
    public ApiResponse<UserMissionResponseDTO.UserMissionStatusResponseDTO> updateMissionStatus(
            @PathVariable Long missionId,
            @PathVariable Long userId,
            @RequestBody @Valid UserMissionRequestDTO.ChallengeMissionRequestDTO request) {

        UserMissionResponseDTO.UserMissionStatusResponseDTO response =
                userMissionCommandService.updateMissionStatus(userId, missionId, request);

        return ApiResponse.onSuccess(response);
    }
}
