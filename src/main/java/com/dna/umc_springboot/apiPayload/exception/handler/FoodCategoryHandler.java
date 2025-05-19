package com.dna.umc_springboot.apiPayload.exception.handler;

import com.dna.umc_springboot.apiPayload.code.status.ErrorStatus;
import com.dna.umc_springboot.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}

