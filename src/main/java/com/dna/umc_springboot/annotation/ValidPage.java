package com.dna.umc_springboot.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
//@Constraint(validatedBy = ValidPageValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPage {
    String message() default "page는 1 이상의 숫자여야 합니다.";
//    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
}
