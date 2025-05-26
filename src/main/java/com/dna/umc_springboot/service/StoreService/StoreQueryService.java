package com.dna.umc_springboot.service.StoreService;

import com.dna.umc_springboot.DTO.StoreResponseDTO;
import com.dna.umc_springboot.domain.Review;
import com.dna.umc_springboot.domain.Store;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);

    //StoreResponseDTO.ReviewPreViewListDTO getReviewList(Long storeId, Integer page);
    Page<Review> getReviewList(Long StoreId, Integer page);
}