package com.dna.umc_springboot.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionNotDuplicatedValidator.class)
@Target({ ElementType.FIELD })  // 필드에 적용
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMissionNotDuplicated {
    String message() default "이미 도전 중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
