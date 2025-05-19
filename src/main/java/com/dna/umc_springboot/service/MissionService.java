package com.dna.umc_springboot.service;

import com.dna.umc_springboot.DTO.MissionRequestDTO;
import com.dna.umc_springboot.converter.MissionConverter;
import com.dna.umc_springboot.domain.Mission;
import com.dna.umc_springboot.domain.Store;
import com.dna.umc_springboot.repository.MissionRepository;
import com.dna.umc_springboot.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public Mission createMission(MissionRequestDTO.CreateDTO request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        Mission mission = MissionConverter.toMission(request, store);
        return missionRepository.save(mission);
    }
}