package com.dna.umc_springboot.converter;

import com.dna.umc_springboot.DTO.MissionRequestDTO;
import com.dna.umc_springboot.DTO.MissionResponseDTO;
import com.dna.umc_springboot.domain.Mission;
import com.dna.umc_springboot.domain.Store;
import com.dna.umc_springboot.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.CreateDTO request, Store store) {
        return Mission.builder()
                .content(request.getContent())
                .point(request.getPoint())
                .store(store)
                .build();
    }

    public static MissionResponseDTO.StoreMissionDTO toStoreMissionDTO(Page<Mission> missionPage) {
        List<MissionResponseDTO.StoreMissionPreview> missionList = missionPage.stream()
                .map(mission -> MissionResponseDTO.StoreMissionPreview.builder()
                        .id(mission.getId())
                        .content(mission.getContent())
                        .point(mission.getPoint())
                        .build())
                .collect(Collectors.toList());

        return MissionResponseDTO.StoreMissionDTO.builder()
                .missions(missionList)
                .listSize(missionList.size())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();
    }
    public static MissionResponseDTO.MyChallengingMissionListDTO toMyChallengingMissionListDTO(Page<MemberMission> missions) {
        List<MissionResponseDTO.MyChallengingMissionDTO> missionDTOs = missions.getContent().stream()
                .map(mm -> MissionResponseDTO.MyChallengingMissionDTO.builder()
                        .missionId(mm.getMission().getId())
                        .content(mm.getMission().getContent())
                        .point(mm.getMission().getPoint())
                        .createdAt(mm.getCreatedAt().toLocalDate())
                        .build()
                ).collect(Collectors.toList());

        return MissionResponseDTO.MyChallengingMissionListDTO.builder()
                .missions(missionDTOs)
                .listSize(missionDTOs.size())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .build();
    }




}
