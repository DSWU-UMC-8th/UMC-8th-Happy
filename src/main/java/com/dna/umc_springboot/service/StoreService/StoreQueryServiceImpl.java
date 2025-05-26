package com.dna.umc_springboot.service.StoreService;

import com.dna.umc_springboot.DTO.StoreResponseDTO;
import com.dna.umc_springboot.domain.Review;
import com.dna.umc_springboot.domain.Store;
import com.dna.umc_springboot.repository.ReviewRepository;
import com.dna.umc_springboot.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;

    private final ReviewRepository reviewRepository;
    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {

        Store store = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }
//    @Override
//    public StoreResponseDTO.ReviewPreViewListDTO getReviewList(Long storeId, Integer page) {
//        // 예시: 리뷰 목록 불러오는 로직을 여기에 작성
//        // 추후 storeId, page를 바탕으로 실제 리뷰를 가져와서 DTO로 매핑
//
//        return new StoreResponseDTO.ReviewPreViewListDTO(); // 더미 리턴
//    }
}