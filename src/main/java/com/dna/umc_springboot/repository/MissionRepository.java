package com.dna.umc_springboot.repository;

import com.dna.umc_springboot.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
