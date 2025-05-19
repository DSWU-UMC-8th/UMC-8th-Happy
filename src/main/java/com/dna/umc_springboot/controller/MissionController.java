package com.dna.umc_springboot.controller;

import com.dna.umc_springboot.DTO.MissionRequestDTO;
import com.dna.umc_springboot.apiPayload.ApiResponse;
import com.dna.umc_springboot.converter.MissionConverter;
import com.dna.umc_springboot.domain.Mission;
import com.dna.umc_springboot.service.MissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping
    public ApiResponse<Long> createMission(@RequestBody @Valid MissionRequestDTO.CreateDTO request) {
        Mission mission = missionService.createMission(request);
        return ApiResponse.onSuccess(mission.getId());
    }
}

