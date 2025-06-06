package com.dna.umc_springboot.converter;

import com.dna.umc_springboot.DTO.MemberRequestDTO;
import com.dna.umc_springboot.DTO.MemberResponseDTO;
import com.dna.umc_springboot.domain.Member; // 실제 위치에 따라 경로 조정
import com.dna.umc_springboot.domain.enums.Gender;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static MemberResponseDTO.LoginResultDTO toLoginResultDTO(Long memberId, String accessToken) {
        return MemberResponseDTO.LoginResultDTO.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .build();
    }
    public static MemberResponseDTO.MemberInfoDTO toMemberInfoDTO(Member member){
        return MemberResponseDTO.MemberInfoDTO.builder()
                .name(member.getName())
                .email(member.getEmail())
                .gender(member.getGender().name())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                //gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .email(request.getEmail())   // 추가된 코드
                //.password(request.getPassword())   // 추가된 코드
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .role(request.getRole())   // 추가된 코드
                .memberPreferList(new ArrayList<>())
                .build();
    }
}