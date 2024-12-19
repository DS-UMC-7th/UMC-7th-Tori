package com.workbook.web.dto;

import com.workbook.domain.enums.Role;
import com.workbook.validation.annotation.ExistCategories;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public class UserRequestDTO {

    @Getter
    @Setter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotBlank
        @Email
        String email;
        @NotBlank
        String password;
        @NotNull
        Integer gender;
        @NotNull
        LocalDate birth;
        String address;
        String nickname;
        @ExistCategories
        List<Long> userFoodCategories;
        @NotNull
        Role role;
    }
}
