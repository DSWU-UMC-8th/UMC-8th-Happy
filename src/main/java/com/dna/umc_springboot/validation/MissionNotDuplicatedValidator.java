package com.dna.umc_springboot.validation;

import com.dna.umc_springboot.repository.MemberMissionRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MissionNotDuplicatedValidator implements ConstraintValidator<ValidMissionNotDuplicated, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        if (missionId == null) {
            return true; // missionId가 null이면 다른 @NotNull에서 걸리게 둠
        }

        Long memberId = 1L; // 실제 서비스에서는 인증된 사용자 ID 사용
        boolean exists = memberMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);

        return !exists;
    }
}
