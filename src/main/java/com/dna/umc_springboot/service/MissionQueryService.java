package com.dna.umc_springboot.service;

import com.dna.umc_springboot.domain.Mission;
import com.dna.umc_springboot.domain.Review;
import com.dna.umc_springboot.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;

public interface MissionQueryService {
    Page<Review> getMyReviews(Long memberId, int page);
    Page<Mission> getMissionsByStoreId(Long storeId, int page);
    Page<MemberMission> getChallengingMissions(Long memberId, int page);

}
