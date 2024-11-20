package com.workbook.apiPayload.exception.handler;

import com.workbook.apiPayload.code.BaseErrorCode;
import com.workbook.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
