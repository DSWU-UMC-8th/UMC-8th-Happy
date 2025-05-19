package com.dna.umc_springboot.DTO;

import com.dna.umc_springboot.validation.annotation.ExistCategories;
import lombok.Getter;

import java.util.List;

@Getter
public class JoinDto{
    String name;
    Integer gender;
    Integer birthYear;
    Integer birthMonth;
    Integer birthDay;
    String address;
    String specAddress;
    @ExistCategories
    List<Long> preferCategory;
}