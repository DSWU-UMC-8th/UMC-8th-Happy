package com.dna.umc_springboot.controller;

import com.dna.umc_springboot.DTO.ReviewRequestDTO;
import com.dna.umc_springboot.apiPayload.ApiResponse;
import com.dna.umc_springboot.converter.ReviewConverter;
import com.dna.umc_springboot.domain.Review;
import com.dna.umc_springboot.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ApiResponse<?> createReview(@RequestBody @Valid ReviewRequestDTO.CreateDTO request) {
        Review review = reviewService.createReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewDTO(review));
    }
}
