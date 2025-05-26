package com.dna.umc_springboot.service;

import com.dna.umc_springboot.domain.Mission;
import com.dna.umc_springboot.domain.Review;
import com.dna.umc_springboot.domain.Store;
import com.dna.umc_springboot.domain.mapping.MemberMission;
import com.dna.umc_springboot.repository.MemberMissionRepository;
import com.dna.umc_springboot.repository.MissionRepository;
import com.dna.umc_springboot.repository.ReviewRepository;
import com.dna.umc_springboot.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.dna.umc_springboot.domain.enums.MissionStatus;
@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<Review> getMyReviews(Long memberId, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return reviewRepository.findAllByMemberId(memberId, pageable);
    }


    public Page<Mission> getMissionsByStoreId(Long storeId, int page) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        return missionRepository.findAllByStore(store, PageRequest.of(page, 10));
    }

    @Override
    public Page<MemberMission> getChallengingMissions(Long memberId, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return memberMissionRepository.findAllByMemberIdAndStatus(memberId, MissionStatus.CHALLENGING, pageable);
    }

}
