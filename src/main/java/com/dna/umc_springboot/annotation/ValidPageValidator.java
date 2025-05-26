package com.dna.umc_springboot.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class ValidPageValidator implements ConstraintValidator<ValidPage, Integer> {
    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        return page != null && page >= 1;
    }
}
