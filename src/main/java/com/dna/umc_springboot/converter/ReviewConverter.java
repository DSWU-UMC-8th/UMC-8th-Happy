package com.dna.umc_springboot.converter;

import com.dna.umc_springboot.DTO.ReviewRequestDTO;
import com.dna.umc_springboot.domain.Member;
import com.dna.umc_springboot.domain.Review;
import com.dna.umc_springboot.domain.Store;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.CreateDTO dto, Member member, Store store) {
        return Review.builder()
                .title(dto.getTitle())
                .score(dto.getScore())
                .member(member)
                .store(store)
                .build();
    }

    public static Object toReviewDTO(Review review) {
        // 필요시 응답 DTO 구성
        return null;
    }
}
