package com.workbook.service.UserMissionService;

import com.workbook.converter.UserMissionConverter;
import com.workbook.domain.Mission;
import com.workbook.domain.User;
import com.workbook.domain.enums.MissionStatus;
import com.workbook.domain.mapping.UserMission;
import com.workbook.repository.MissionRepository;
import com.workbook.repository.UserMissionRepository;
import com.workbook.repository.UserRepository;
import com.workbook.web.dto.UserMissionRequestDTO;
import com.workbook.web.dto.UserMissionResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {

    private final UserMissionRepository userMissionRepository;
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserMissionResponseDTO.UserMissionStatusResponseDTO updateMissionStatus(
            Long userId, Long missionId, UserMissionRequestDTO.ChallengeMissionRequestDTO request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new RuntimeException("Mission not found"));

        if (request.getStatus() == MissionStatus.CHALLENGING) {
            boolean isMissionInProgress = userMissionRepository.existsByUserAndMissionAndStatus(user, mission, MissionStatus.CHALLENGING);
            if (isMissionInProgress) {
                throw new RuntimeException("이미 도전 중인 미션입니다.");
            }
        }

        UserMission userMission = userMissionRepository.findByUserAndMission(user, mission)
                .orElseThrow(() -> new RuntimeException("UserMission not found"));

        userMission.setStatus(request.getStatus());

        return UserMissionConverter.toUserMissionStatusResponseDTO(userMission);
    }
}
