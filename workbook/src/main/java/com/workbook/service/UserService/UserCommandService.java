package com.workbook.service.UserService;

import com.workbook.domain.User;
import com.workbook.web.dto.UserRequestDTO;

public interface UserCommandService {

    User joinUser(UserRequestDTO.JoinDto request);
}
