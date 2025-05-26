package com.dna.umc_springboot.repository.StoreRepository;

import com.dna.umc_springboot.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//package com.dna.umc_springboot.repository.StoreRepository;
//
//import com.dna.umc_springboot.domain.Store;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
//}
public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
