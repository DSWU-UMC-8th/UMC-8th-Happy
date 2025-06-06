package com.dna.umc_springboot.service.MemberCommandService;

import com.dna.umc_springboot.DTO.MemberResponseDTO;
import com.dna.umc_springboot.apiPayload.code.status.ErrorStatus;
import com.dna.umc_springboot.apiPayload.exception.handler.MemberHandler;
import com.dna.umc_springboot.config.security.jwt.JwtTokenProvider;
import com.dna.umc_springboot.converter.MemberConverter;
import com.dna.umc_springboot.domain.Member;
import com.dna.umc_springboot.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional(readOnly = true)
    public MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return MemberConverter.toMemberInfoDTO(member);
    }
}