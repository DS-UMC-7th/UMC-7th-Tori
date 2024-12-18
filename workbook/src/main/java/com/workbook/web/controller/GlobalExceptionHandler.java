package com.workbook.web.controller;

import com.workbook.apiPayload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ApiResponse<String> handleIllegalArgumentException(IllegalArgumentException e) {

        return ApiResponse.onFailure(String.valueOf(HttpStatus.BAD_REQUEST.value()), e.getMessage(), null);
    }
}
