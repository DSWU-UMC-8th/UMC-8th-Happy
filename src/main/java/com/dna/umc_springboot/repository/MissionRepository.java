package com.dna.umc_springboot.repository;

import com.dna.umc_springboot.domain.Mission;
import com.dna.umc_springboot.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByStore(Store store, Pageable pageable);

}