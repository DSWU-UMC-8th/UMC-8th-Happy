package com.dna.umc_springboot.controller;

import com.dna.umc_springboot.DTO.MemberRequestDTO;
import com.dna.umc_springboot.DTO.MemberResponseDTO;
import com.dna.umc_springboot.apiPayload.ApiResponse;
import com.dna.umc_springboot.converter.MemberConverter;
import com.dna.umc_springboot.domain.Member;
import com.dna.umc_springboot.service.MemberCommandService.MemberCommandService;
import com.dna.umc_springboot.service.MemberCommandService.MemberQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

//    @PostMapping("/")
//    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
//        Member member = memberCommandService.joinMember(request);
//        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
//    }
//    @PostMapping("/join")
//    @Operation(summary = "유저 회원가입 API",description = "유저가 회원가입하는 API입니다.")
//    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
//        Member member = memberCommandService.joinMember(request);
//        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
//    }
//
//    @PostMapping("/login")
//    @Operation(summary = "유저 로그인 API",description = "유저가 로그인하는 API입니다.")
//    public ApiResponse<MemberResponseDTO.LoginResultDTO> login(@RequestBody @Valid MemberRequestDTO.LoginRequestDTO request) {
//        return ApiResponse.onSuccess(memberCommandService.loginMember(request));
//    }
//
//    @GetMapping("/info")
//    @Operation(summary = "유저 내 정보 조회 API - 인증 필요",
//            description = "유저가 내 정보를 조회하는 API입니다.",
//            security = { @SecurityRequirement(name = "JWT TOKEN") }
//    )
    public ApiResponse<MemberResponseDTO.MemberInfoDTO> getMyInfo(HttpServletRequest request) {
        return ApiResponse.onSuccess(memberQueryService.getMemberInfo(request));
    }
}
