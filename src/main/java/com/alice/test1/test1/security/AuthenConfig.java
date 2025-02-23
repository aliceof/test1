package com.alice.test1.test1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class AuthenConfig {
    @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                authorizeHttpRequests(auth->auth
                .anyRequest().authenticated())
                .cors(Customizer.withDefaults())
                .csrf(csrf->csrf.disable())
                .formLogin(form->form.loginPage("/login").permitAll())
                .logout(logout->logout.permitAll());

        return http.build();

    }
}
