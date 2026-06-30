package com.rudra.ShortForm;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> {
                })
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/about").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/save").permitAll()

                        .requestMatchers("/gff").authenticated()

                        .requestMatchers("/all").hasRole("ADMIN")
                        .requestMatchers("/add").hasRole("ADMIN")
                        .requestMatchers("/del").hasRole("ADMIN")

                        .requestMatchers("/check").authenticated()

                        .anyRequest().permitAll())
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint((req, res, e) -> res.setStatus(401)))
                .formLogin(form -> form
                        .loginProcessingUrl("/login")
                        .successHandler((req, res, auth) -> res.setStatus(200))
                        .failureHandler((req, res, e) -> res.setStatus(401)))
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessHandler((req, res, auth) -> res.setStatus(200)));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}