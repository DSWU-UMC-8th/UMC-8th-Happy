package com.dna.umc_springboot.DTO;

import com.dna.umc_springboot.validation.annotation.ValidStoreExists;
import jakarta.validation.constraints.*;

import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class CreateDTO {

        @ValidStoreExists
        private Long storeId;

        @NotBlank
        private String title;

        @NotNull
        @DecimalMin(value = "0.0", inclusive = true)
        @DecimalMax(value = "5.0", inclusive = true)
        private Float score;
    }
}

