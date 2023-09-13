package com.example.tastyapp.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

public class AppSecurityConfig extends WebSecurityConfiguration {
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeHttpRequests()
                .anyRequest()
                .fullyAuthenticated();
}
    }
