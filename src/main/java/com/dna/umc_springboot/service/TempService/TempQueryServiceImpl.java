package com.dna.umc_springboot.service.TempService;

import com.dna.umc_springboot.apiPayload.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.dna.umc_springboot.apiPayload.code.status.ErrorStatus;

@Service("tempQueryServiceImpl")
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}