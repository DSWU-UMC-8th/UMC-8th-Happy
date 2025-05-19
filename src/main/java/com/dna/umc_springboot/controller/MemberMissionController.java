package com.dna.umc_springboot.controller;

import com.dna.umc_springboot.DTO.MemberMissionRequestDTO;
import com.dna.umc_springboot.apiPayload.ApiResponse;
import com.dna.umc_springboot.service.MemberMissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member-missions")
public class MemberMissionController {

    private final MemberMissionService memberMissionService;

    @PostMapping("/")
    public ApiResponse<String> challengeMission(@RequestBody @Valid MemberMissionRequestDTO.Create request) {
        memberMissionService.challengeMission(request);
        return ApiResponse.onSuccess("미션 도전 성공");
    }
}

