package com.dna.umc_springboot.repository;

import com.dna.umc_springboot.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
