package com.dna.umc_springboot.controller;

import com.dna.umc_springboot.DTO.StoreRequestDTO;
import com.dna.umc_springboot.DTO.StoreResponseDTO;
import com.dna.umc_springboot.apiPayload.ApiResponse;
import com.dna.umc_springboot.converter.StoreConverter;
import com.dna.umc_springboot.domain.Store;
import com.dna.umc_springboot.service.StoreService.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    public ApiResponse<StoreResponseDTO.ResultDTO> create(@RequestBody @Valid StoreRequestDTO.CreateDTO dto) {
        Store store = storeService.createStore(dto);
        return ApiResponse.onSuccess(StoreConverter.toResultDTO(store));
    }
}
