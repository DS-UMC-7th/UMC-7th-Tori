package com.workbook.validation.validator;

import com.workbook.domain.User;
import com.workbook.domain.Mission;
import com.workbook.domain.enums.MissionStatus;
import com.workbook.repository.UserMissionRepository;
import com.workbook.validation.annotation.MissionNotInProgress;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MissionNotInProgressValidator implements ConstraintValidator<MissionNotInProgress, Long> {

    private final UserMissionRepository userMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {

        Mission mission = new Mission();
        mission.setMissionId(missionId);

        boolean isMissionInProgress = userMissionRepository.existsByUserAndMissionAndStatus(null, mission, MissionStatus.CHALLENGING);

        if (isMissionInProgress) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("이미 도전 중인 미션입니다.")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
