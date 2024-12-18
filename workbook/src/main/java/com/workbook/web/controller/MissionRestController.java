package com.workbook.web.controller;

import com.workbook.apiPayload.ApiResponse;
import com.workbook.converter.MissionConverter;
import com.workbook.domain.Mission;
import com.workbook.service.MissionService.MissionCommandService;
import com.workbook.service.MissionService.MissionQueryService;
import com.workbook.validation.annotation.PageValid;
import com.workbook.web.dto.MissionRequestDTO;
import com.workbook.web.dto.MissionResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.CreateMissionResponseDTO> join(@RequestBody @Valid MissionRequestDTO.CreateMissionRequestDTO request) {
        Mission mission = missionCommandService.createMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResponseDTO(mission));
    }

    @GetMapping("/restaurant/{restaurantId}")
    @Operation(summary = "특정 가게 미션 목록 조회", description = "가게 ID를 기반으로 미션 목록을 페이징 처리하여 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK ,성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<List<MissionResponseDTO.MissionDTO>> getMissionsByRestaurant(@PathVariable Long restaurantId, @RequestParam @PageValid Integer page) {
        if (page < 1) {
            throw new IllegalArgumentException("페이지 번호는 1 이상이어야 합니다.");
        }

        Page<Mission> missions = missionQueryService.getMissionsByRestaurant(restaurantId, page - 1);
        List<MissionResponseDTO.MissionDTO> missionDTOList = MissionConverter.toMissionDTOList(missions.getContent());
        return ApiResponse.onSuccess(missionDTOList);
    }
}
