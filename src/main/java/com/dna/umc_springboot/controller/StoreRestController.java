package com.dna.umc_springboot.controller;

import com.dna.umc_springboot.DTO.MissionResponseDTO;
import com.dna.umc_springboot.DTO.StoreResponseDTO;
import com.dna.umc_springboot.annotation.ValidPage;
import com.dna.umc_springboot.apiPayload.ApiResponse;
import com.dna.umc_springboot.converter.ReviewConverter;
import com.dna.umc_springboot.converter.StoreConverter;
import com.dna.umc_springboot.domain.Review;
import com.dna.umc_springboot.service.MissionQueryService;
import com.dna.umc_springboot.service.StoreService.StoreQueryService;
import com.dna.umc_springboot.validation.ExistStore;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreQueryService storeQueryService;
    private final MissionQueryService missionQueryService;

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId,@RequestParam(name = "page") Integer page){
        var reviewList = storeQueryService.getReviewList(storeId,page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }

    @Operation(summary = "내가 작성한 리뷰 목록", description = "로그인한 회원의 리뷰를 페이지 단위로 조회합니다.")
    @GetMapping("/my-reviews")
    public ApiResponse<List<MissionResponseDTO.MyReviewDTO>> getMyReviews(
            @ValidPage Integer page // ✅ 핵심: RequestParam 제거
    ) {
        System.out.println(">>> 받은 page = " + page);
        Long memberId = 1L;
        Page<Review> reviewPage = missionQueryService.getMyReviews(memberId, page);
        List<MissionResponseDTO.MyReviewDTO> result = ReviewConverter.toMyReviewDTOList(reviewPage.getContent());
        return ApiResponse.onSuccess(result);
    }



}