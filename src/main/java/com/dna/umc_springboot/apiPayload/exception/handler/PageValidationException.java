package com.dna.umc_springboot.apiPayload.exception.handler;

public class PageValidationException extends RuntimeException {
    public PageValidationException(String message) {
        super(message);
    }
}
