package com.workbook.web.dto;

import com.workbook.validation.annotation.ExistCategories;
import lombok.Getter;
import java.time.LocalDate;
import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDto{
        String name;
        Integer gender;
        LocalDate birth;
        String address;
        String nickname;
        @ExistCategories
        List<Long> userFoodCategories;
    }
}
