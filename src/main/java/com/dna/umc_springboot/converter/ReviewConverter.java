package com.dna.umc_springboot.converter;

import com.dna.umc_springboot.DTO.MissionResponseDTO;
import com.dna.umc_springboot.DTO.ReviewRequestDTO;
import com.dna.umc_springboot.domain.Member;
import com.dna.umc_springboot.domain.Review;
import com.dna.umc_springboot.domain.Store;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<MissionResponseDTO.MyReviewDTO> toMyReviewDTOList(List<Review> reviews) {
        return reviews.stream().map(review ->
                MissionResponseDTO.MyReviewDTO.builder()
                        .title(review.getTitle())
                        .score(review.getScore())
                        .storeName(review.getStore().getName())
                        .createdAt(review.getCreatedAt().toLocalDate())
                        .build()
        ).collect(Collectors.toList());
    }
//    public static MissionResponseDTO.MyReviewDTO toMyReviewDTO(Review review) {
//        return MissionResponseDTO.MyReviewDTO.builder()
//                .storeName(review.getStore().getName())
//                .score(review.getScore())
//                .body(review.getTitle())
//                .createdAt(review.getCreatedAt().toLocalDate())
//                .build();
//    }

//    public static List<MissionResponseDTO.MyReviewDTO> toMyReviewDTOList(List<Review> reviews) {
//        return reviews.stream().map(ReviewConverter::toMyReviewDTO).collect(Collectors.toList());
//    }
}
