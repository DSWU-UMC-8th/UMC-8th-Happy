package com.dna.umc_springboot.service.StoreService;

import com.dna.umc_springboot.DTO.StoreRequestDTO;
import com.dna.umc_springboot.converter.StoreConverter;
import com.dna.umc_springboot.domain.Store;
import com.dna.umc_springboot.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public Store createStore(StoreRequestDTO.CreateDTO dto) {
        Store store = StoreConverter.toStore(dto);
        return storeRepository.save(store);
    }
}
