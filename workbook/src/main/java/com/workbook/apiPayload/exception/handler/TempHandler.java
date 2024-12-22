package com.workbook.apiPayload.exception.handler;

import com.workbook.apiPayload.code.BaseErrorCode;
import com.workbook.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
