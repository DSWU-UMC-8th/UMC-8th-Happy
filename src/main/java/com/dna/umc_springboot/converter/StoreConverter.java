package com.dna.umc_springboot.converter;

import com.dna.umc_springboot.DTO.StoreRequestDTO;
import com.dna.umc_springboot.DTO.StoreResponseDTO;
import com.dna.umc_springboot.domain.Review;
import com.dna.umc_springboot.domain.Store;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.CreateDTO dto) {
        return Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .region(dto.getRegion())
                .build();
    }

    public static StoreResponseDTO.ResultDTO toResultDTO(Store store) {
        return StoreResponseDTO.ResultDTO.builder()
                .storeId(store.getId())
                .name(store.getName())
                .region(store.getRegion())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getTitle())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}

