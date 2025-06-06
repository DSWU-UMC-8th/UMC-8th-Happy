package com.dna.umc_springboot.service.MemberCommandService;

import com.dna.umc_springboot.DTO.MemberResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface MemberQueryService {
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}