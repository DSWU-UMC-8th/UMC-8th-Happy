package com.dna.umc_springboot.service.MemberCommandService;

import com.dna.umc_springboot.DTO.MemberRequestDTO;
import com.dna.umc_springboot.apiPayload.exception.handler.FoodCategoryHandler;
import com.dna.umc_springboot.converter.MemberConverter;
import com.dna.umc_springboot.converter.MemberPreferConverter;
import com.dna.umc_springboot.domain.FoodCategory;
import com.dna.umc_springboot.domain.Member;
import com.dna.umc_springboot.domain.mapping.MemberPrefer;
import com.dna.umc_springboot.repository.FoodCategoryRepository;
import com.dna.umc_springboot.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.dna.umc_springboot.apiPayload.code.status.ErrorStatus;

import com.dna.umc_springboot.domain.mapping.MemberPrefer;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}