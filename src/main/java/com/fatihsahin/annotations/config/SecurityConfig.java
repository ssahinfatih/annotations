package com.fatihsahin.annotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Bu class'ın Security configuration olduğunu belirtir.
@EnableWebSecurity // Spring Security'nin web güvenliğini etkinleştirir.
public class SecurityConfig {
    @Bean // Kullanıcı bilgilerini Spring Security'ye verir.
    public UserDetailsService userDetailsService() {

        UserDetails user = User
                .withUsername("fatih") // Kullanıcı adını belirler.
                .password("{noop}1234") // Şimdilik basit şifre kullanıyoruz.
                .roles("USER") // Kullanıcıya USER rolü veriyoruz.
                .build();

        // Kullanıcıyı bellekte tutan UserDetailsService oluşturur.
        return new InMemoryUserDetailsManager(user);
    }

    @Bean // SecurityFilterChain'i Spring Bean olarak oluşturur.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // Tüm endpointler giriş yapmış kullanıcıya açık.
                )
                .httpBasic(Customizer.withDefaults()); // Basit kullanıcı adı/şifre authentication kullanır.

        // Security ayarlarını tamamlayıp SecurityFilterChain oluşturur.
        return http.build();
    }
}