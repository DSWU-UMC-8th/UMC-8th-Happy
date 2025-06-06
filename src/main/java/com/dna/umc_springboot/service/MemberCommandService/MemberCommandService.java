package com.dna.umc_springboot.service.MemberCommandService;

import com.dna.umc_springboot.DTO.MemberRequestDTO;
import com.dna.umc_springboot.DTO.MemberResponseDTO;
import com.dna.umc_springboot.domain.Member;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);

    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);
}

