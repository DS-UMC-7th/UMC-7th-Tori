package com.workbook.converter;

import com.workbook.domain.User;
import com.workbook.domain.enums.Gender;
import com.workbook.web.dto.UserRequestDTO;
import com.workbook.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getUserId())
                .createdAt(LocalDateTime.now())
                .build();

    }

    public static User toUser(UserRequestDTO.JoinDto request){
        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2 :
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.OTHER;
                break;
        }

        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .birth(request.getBirth())
                .address(request.getAddress())
                .gender(gender)
                .userFoodCategories(new ArrayList<>())
                .role(request.getRole())
                .build();
    }
}
