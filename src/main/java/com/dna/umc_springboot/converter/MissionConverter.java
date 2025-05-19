package com.dna.umc_springboot.converter;

import com.dna.umc_springboot.DTO.MissionRequestDTO;
import com.dna.umc_springboot.domain.Mission;
import com.dna.umc_springboot.domain.Store;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.CreateDTO request, Store store) {
        return Mission.builder()
                .content(request.getContent())
                .point(request.getPoint())
                .store(store)
                .build();
    }
}
