package com.dna.umc_springboot.repository;

import com.dna.umc_springboot.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
