package com.dna.umc_springboot.service.MemberCommandService;

import com.dna.umc_springboot.DTO.MemberRequestDTO;
import com.dna.umc_springboot.apiPayload.exception.handler.FoodCategoryHandler;
import com.dna.umc_springboot.apiPayload.exception.handler.MemberHandler;
import com.dna.umc_springboot.converter.MemberConverter;
import com.dna.umc_springboot.converter.MemberPreferConverter;
import com.dna.umc_springboot.domain.FoodCategory;
import com.dna.umc_springboot.domain.Member;
import com.dna.umc_springboot.domain.mapping.MemberPrefer;
import com.dna.umc_springboot.repository.FoodCategoryRepository;
import com.dna.umc_springboot.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.dna.umc_springboot.apiPayload.code.status.ErrorStatus;
import com.dna.umc_springboot.DTO.MemberResponseDTO;
import com.dna.umc_springboot.config.security.jwt.JwtTokenProvider;
import com.dna.umc_springboot.domain.mapping.MemberPrefer;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        //newMember.encodePassword(passwordEncoder.encode(request.getPassword()));
        String encoded = passwordEncoder.encode(request.getPassword());
        newMember.encodePassword(encoded); // setter를 통해 비밀번호 주입

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
    @Override
    @Transactional
    public MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if(!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new MemberHandler(ErrorStatus.INVALID_PASSWORD);
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                member.getEmail(), null,
                Collections.singleton(() -> member.getRole().name())
        );

        String accessToken = jwtTokenProvider.generateToken(authentication);

        return MemberConverter.toLoginResultDTO(
                member.getId(),
                accessToken
        );
    }
}