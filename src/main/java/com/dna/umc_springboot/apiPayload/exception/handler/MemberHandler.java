package com.dna.umc_springboot.apiPayload.exception.handler;

import com.dna.umc_springboot.apiPayload.code.BaseErrorCode;
import com.dna.umc_springboot.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {

    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
