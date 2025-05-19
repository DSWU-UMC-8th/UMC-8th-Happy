package com.dna.umc_springboot.controller;

import com.dna.umc_springboot.DTO.MemberRequestDTO;
import com.dna.umc_springboot.DTO.MemberResponseDTO;
import com.dna.umc_springboot.apiPayload.ApiResponse;
import com.dna.umc_springboot.converter.MemberConverter;
import com.dna.umc_springboot.domain.Member;
import com.dna.umc_springboot.service.MemberCommandService.MemberCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
