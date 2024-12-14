package com.workbook.repository;

import com.workbook.domain.mapping.UserMission;
import com.workbook.domain.User;
import com.workbook.domain.Mission;
import com.workbook.domain.enums.MissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    Optional<UserMission> findByUserAndMission(User user, Mission mission);

    boolean existsByUserAndMissionAndStatus(User user, Mission mission, MissionStatus status);
}
