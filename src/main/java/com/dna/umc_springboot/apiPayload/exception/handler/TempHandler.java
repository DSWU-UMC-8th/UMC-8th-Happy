package com.dna.umc_springboot.apiPayload.exception.handler;

import com.dna.umc_springboot.apiPayload.code.BaseErrorCode;
import com.dna.umc_springboot.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
