package com.dna.umc_springboot.repository;

import com.dna.umc_springboot.domain.Review;
import com.dna.umc_springboot.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;


public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByMemberId(Long memberId, Pageable pageable);
    Page<Review> findAllByStore(Store store, Pageable pageable);
}