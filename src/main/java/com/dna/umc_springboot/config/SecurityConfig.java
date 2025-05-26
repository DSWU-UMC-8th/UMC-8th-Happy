//package com.dna.umc_springboot.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(
//                                "/swagger-ui/**",
//                                "/swagger-ui.html",
//                                "/v3/api-docs/**"
//                        ).permitAll()
//                        .anyRequest().permitAll() // 개발 중엔 전부 허용
//                )
//                .formLogin().disable()
//                .httpBasic().disable();
//
//        return http.build();
//    }
//}
//
