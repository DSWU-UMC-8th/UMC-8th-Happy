package com.dna.umc_springboot.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class MissionResponseDTO {
    @Builder
    @Getter
    public static class MyReviewDTO {
        private String title;
        private Float score;
        private String storeName;
        private LocalDate createdAt;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreMissionDTO {
        private List<StoreMissionPreview> missions;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreMissionPreview {
        private Long id;
        private String content;
        private Integer point;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyChallengingMissionDTO {
        private Long missionId;
        private String content;
        private Integer point;
        private LocalDate createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyChallengingMissionListDTO {
        private List<MyChallengingMissionDTO> missions;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }
}
