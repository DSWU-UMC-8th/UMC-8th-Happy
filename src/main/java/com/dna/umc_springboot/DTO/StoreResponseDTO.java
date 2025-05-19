package com.dna.umc_springboot.DTO;

import lombok.Builder;
import lombok.Getter;

public class StoreResponseDTO {

    @Builder
    @Getter
    public static class ResultDTO {
        private Long storeId;
        private String name;
        private String region;
    }
}

