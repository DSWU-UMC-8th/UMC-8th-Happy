package com.dna.umc_springboot.service;

import com.dna.umc_springboot.DTO.MemberMissionRequestDTO;
import com.dna.umc_springboot.domain.Member;
import com.dna.umc_springboot.domain.Mission;
import com.dna.umc_springboot.domain.enums.MissionStatus;
import com.dna.umc_springboot.domain.mapping.MemberMission;
import com.dna.umc_springboot.repository.MemberMissionRepository;
import com.dna.umc_springboot.repository.MemberRepository;
import com.dna.umc_springboot.repository.MissionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Transactional
    public MemberMission challengeMission(MemberMissionRequestDTO.Create request) {
        Member member = memberRepository.findById(1L).orElseThrow();
        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow();

        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();

        return memberMissionRepository.save(memberMission);
    }
}
