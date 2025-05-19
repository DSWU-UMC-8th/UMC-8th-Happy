package com.dna.umc_springboot.validation.validator;

import com.dna.umc_springboot.repository.StoreRepository.StoreRepository;
import com.dna.umc_springboot.validation.annotation.ValidStoreExists;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreExistsValidator implements ConstraintValidator<ValidStoreExists, Long> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        if (storeId == null) return false;
        return storeRepository.existsById(storeId);
    }
}
