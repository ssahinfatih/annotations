package com.fatihsahin.annotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Bu class'ın Security configuration olduğunu belirtir.
@EnableWebSecurity // Spring Security'nin web güvenliğini etkinleştirir.
@EnableMethodSecurity // Method seviyesindeki güvenliği etkinleştirir.
public class SecurityConfig {


    @Bean // SecurityFilterChain'i Spring Bean olarak oluşturur.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable()) // REST API için CSRF kontrolünü kapatır.
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // Tüm endpointler giriş yapmış kullanıcıya açık.
                )
                .httpBasic(Customizer.withDefaults()); // Basit kullanıcı adı/şifre authentication kullanır.

        // Security ayarlarını tamamlayıp SecurityFilterChain oluşturur.
        return http.build();
    }
    @Bean // Kullanıcı bilgilerini Spring Security'ye verir.
    public UserDetailsService userDetailsService() {

        UserDetails user = User
                .withUsername("fatih") // Kullanıcı adını belirler.
                .password("{noop}1234") // Şimdilik basit şifre kullanıyoruz.
                .roles("USER") // Kullanıcıya USER rolü veriyoruz.
                .build();

        UserDetails admin = User
                .withUsername("admin") // Admin kullanıcı.
                .password("{noop}1234") // Eğitim amaçlı şifre.
                .roles("ADMIN") // ADMIN rolü.
                .build();

        // Kullanıcıyı bellekte tutan UserDetailsService oluşturur.
        return new InMemoryUserDetailsManager(user, admin);
    }
}