package com.dna.umc_springboot.validation;

import com.dna.umc_springboot.repository.StoreRepository.StoreRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExistStoreValidator implements ConstraintValidator<ExistStore, Long> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return storeRepository.existsById(value);
    }
}

