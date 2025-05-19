package com.dna.umc_springboot.DTO;

import com.dna.umc_springboot.validation.ValidMissionNotDuplicated;
import lombok.Getter;
import lombok.Setter;

public class MemberMissionRequestDTO {

    @Getter
    @Setter
    public static class Create {
        @ValidMissionNotDuplicated
        private Long missionId;
    }
}
