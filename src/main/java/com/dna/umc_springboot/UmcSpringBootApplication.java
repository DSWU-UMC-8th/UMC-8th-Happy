package com.dna.umc_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UmcSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(UmcSpringBootApplication.class, args);
    }

}
