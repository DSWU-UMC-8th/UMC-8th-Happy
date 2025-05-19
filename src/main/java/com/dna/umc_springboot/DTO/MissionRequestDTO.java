package com.dna.umc_springboot.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class CreateDTO {
        @NotNull
        private Long storeId;

        @NotBlank
        private String content;

        @NotNull
        private Integer point;
    }
}
