package com.dna.umc_springboot.service;

import com.dna.umc_springboot.DTO.ReviewRequestDTO;
import com.dna.umc_springboot.converter.ReviewConverter;
import com.dna.umc_springboot.domain.Member;
import com.dna.umc_springboot.domain.Review;
import com.dna.umc_springboot.domain.Store;
import com.dna.umc_springboot.repository.MemberRepository;
import com.dna.umc_springboot.repository.ReviewRepository;
import com.dna.umc_springboot.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public Review createReview(ReviewRequestDTO.CreateDTO request) {
        // 하드코딩된 유저
        Member member = memberRepository.findById(1L).orElseThrow();

        Store store = storeRepository.findById(request.getStoreId()).orElseThrow();

        Review review = ReviewConverter.toReview(request, member, store);
        return reviewRepository.save(review);
    }
}
