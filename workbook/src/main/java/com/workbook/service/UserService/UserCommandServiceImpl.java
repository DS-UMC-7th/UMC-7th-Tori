package com.workbook.service.UserService;

import com.workbook.apiPayload.code.status.ErrorStatus;
import com.workbook.apiPayload.exception.handler.FoodCategoryHandler;
import com.workbook.converter.UserConverter;
import com.workbook.converter.UserFoodCategoryConverter;
import com.workbook.domain.FoodCategory;
import com.workbook.domain.User;
import com.workbook.domain.mapping.UserFoodCategory;
import com.workbook.repository.FoodCategoryRepository;
import com.workbook.repository.UserRepository;
import com.workbook.web.dto.UserRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request) {

        User newUser = UserConverter.toUser(request);
        List<FoodCategory> foodCategoryList = request.getUserFoodCategories().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserFoodCategory> userFoodCategoryList = UserFoodCategoryConverter.toUserFoodCategoryList(foodCategoryList);

        userFoodCategoryList.forEach(userFoodCategory -> {userFoodCategory.setUser(newUser);});

        return userRepository.save(newUser);
    }
}
