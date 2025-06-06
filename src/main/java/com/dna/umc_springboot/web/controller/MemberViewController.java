package com.dna.umc_springboot.web.controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberViewController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;


    @PostMapping("/join")
    @Operation(summary = "유저 회원가입 API",description = "유저가 회원가입하는 API입니다.")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/login")
    @Operation(summary = "유저 로그인 API",description = "유저가 로그인하는 API입니다.")
    public ApiResponse<MemberResponseDTO.LoginResultDTO> login(@RequestBody @Valid MemberRequestDTO.LoginRequestDTO request) {
        return ApiResponse.onSuccess(memberCommandService.loginMember(request));
    }

    @GetMapping("/info")
    @Operation(summary = "유저 내 정보 조회 API - 인증 필요",
            description = "유저가 내 정보를 조회하는 API입니다.",
            security = { @SecurityRequirement(name = "JWT TOKEN") }
    )
    public ApiResponse<MemberResponseDTO.MemberInfoDTO> getMyInfo(HttpServletRequest request) {
        return ApiResponse.onSuccess(memberQueryService.getMemberInfo(request));
    }
}


//@Controller
//@RequiredArgsConstructor
//
//public class MemberViewController {
//
//    private final MemberCommandService memberCommandService;
//
//    // thymeleaf 사용을 위해 일부가 변경되었습니다.
//    // 실제로는 8주차에서 작성한 컨트롤러와 동일하게 작성하시면 됩니다!!
//    @PostMapping("/members/signup")
//    public String joinMember(@ModelAttribute("memberJoinDto") MemberRequestDTO.JoinDto request, // 협업시에는 기존 RequestBody 어노테이션을 붙여주시면 됩니다!
//                             BindingResult bindingResult,
//                             Model model) {
//        if (bindingResult.hasErrors()) {
//            // 뷰에 데이터 바인딩이 실패할 경우 signup 페이지를 유지합니다.
//            return "signup";
//        }
//
//        try {
//            memberCommandService.joinMember(request);
//            return "redirect:/login";
//        } catch (Exception e) {
//            // 회원가입 과정에서 에러가 발생할 경우 에러 메시지를 보내고, signup 페이디를 유지합니다.
//            model.addAttribute("error", e.getMessage());
//            return "signup";
//        }
//    }
//
//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";
//    }
//
//    @GetMapping("/signup")
//    public String signupPage(Model model) {
//        model.addAttribute("memberJoinDto", new MemberRequestDTO.JoinDto());
//        return "signup";
//    }
//
//    @GetMapping("/home")
//    public String home() {
//        return "home";
//    }
//
//    @GetMapping("/admin")
//    public String admin() {
//        return "admin";
//    }
//}