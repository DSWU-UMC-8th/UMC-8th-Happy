package com.dna.umc_springboot.controller;

import com.dna.umc_springboot.DTO.MissionRequestDTO;
import com.dna.umc_springboot.DTO.MissionResponseDTO;
import com.dna.umc_springboot.apiPayload.ApiResponse;
import com.dna.umc_springboot.converter.MissionConverter;
import com.dna.umc_springboot.domain.Mission;
import com.dna.umc_springboot.domain.mapping.MemberMission;
import com.dna.umc_springboot.service.MissionQueryService;
import com.dna.umc_springboot.service.MissionService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.dna.umc_springboot.annotation.ValidPage;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;
    private final MissionQueryService missionQueryService;

    @PostMapping
    public ApiResponse<Long> createMission(@RequestBody @Valid MissionRequestDTO.CreateDTO request) {
        Mission mission = missionService.createMission(request);
        return ApiResponse.onSuccess(mission.getId());
    }

    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "가게 ID로 미션 목록을 페이징 조회합니다.")
    @GetMapping("/store/{storeId}")
    public ApiResponse<MissionResponseDTO.StoreMissionDTO> getMissionsByStore(
            @PathVariable Long storeId,
            @ValidPage Integer page
    ) {
        Page<Mission> missionPage = missionQueryService.getMissionsByStoreId(storeId, page);
        return ApiResponse.onSuccess(MissionConverter.toStoreMissionDTO(missionPage));
    }

    @Operation(summary = "내가 진행중인 미션 목록", description = "로그인한 사용자의 진행중인 미션 목록을 조회합니다.")
    @GetMapping("/my-challenges")
    public ApiResponse<MissionResponseDTO.MyChallengingMissionListDTO> getMyChallengingMissions(
            @ValidPage Integer page
    ) {
        Long memberId = 1L; // 인증 붙으면 교체
        Page<MemberMission> missions = missionQueryService.getChallengingMissions(memberId, page);
        return ApiResponse.onSuccess(MissionConverter.toMyChallengingMissionListDTO(missions));
    }

    @Operation(summary = "진행 중인 미션을 완료 처리", description = "진행 중인 미션(memberMissionId)의 상태를 COMPLETE로 변경합니다.")
    @PatchMapping("/{memberMissionId}/complete")
    public ApiResponse<String> completeMission(
            @PathVariable Long memberMissionId
    ) {
        missionService.completeMemberMission(memberMissionId);
        return ApiResponse.onSuccess("미션이 완료되었습니다.");
    }
}

