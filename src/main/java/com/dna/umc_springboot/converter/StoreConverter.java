package com.dna.umc_springboot.converter;

import com.dna.umc_springboot.DTO.StoreRequestDTO;
import com.dna.umc_springboot.DTO.StoreResponseDTO;
import com.dna.umc_springboot.domain.Store;

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
}

