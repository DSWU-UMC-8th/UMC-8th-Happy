package com.dna.umc_springboot.service;

import com.dna.umc_springboot.DTO.MissionRequestDTO;
import com.dna.umc_springboot.converter.MissionConverter;
import com.dna.umc_springboot.domain.Mission;
import com.dna.umc_springboot.domain.Store;
import com.dna.umc_springboot.domain.enums.MissionStatus;
import com.dna.umc_springboot.domain.mapping.MemberMission;
import com.dna.umc_springboot.repository.MemberMissionRepository;
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
    private final MemberMissionRepository memberMissionRepository;

    @Transactional
    public Mission createMission(MissionRequestDTO.CreateDTO request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        Mission mission = MissionConverter.toMission(request, store);
        return missionRepository.save(mission);
    }

    @Transactional
    public void completeMemberMission(Long memberMissionId) {
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 미션 도전 기록이 존재하지 않습니다."));

        if (memberMission.getStatus() == MissionStatus.COMPLETE) {
            throw new IllegalStateException("이미 완료된 미션입니다.");
        }

        memberMission.setStatus(MissionStatus.COMPLETE);
    }

}