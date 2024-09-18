package com.Mighty.Performance.configuration;

import com.Mighty.Performance.service.CustomSuccessHandler;
import com.Mighty.Performance.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF for testing, but keep enabled for production use
                .csrf(csrf -> csrf.disable())

                // Authorize HTTP requests
                .authorizeHttpRequests(auth -> auth
                        // Allow access to static resources
                        .requestMatchers("/sneat-1.0.0/**", "/assets/**", "/static/**").permitAll()

                        // Permit access to registration and login pages
                        .requestMatchers("/registration", "/login").permitAll()

                        // Restrict access to role-based pages
                        .requestMatchers("/admin-page").hasAuthority("ADMIN")
                        .requestMatchers("/user-page").hasAuthority("USER")

                        // Any other request needs to be authenticated
                        .anyRequest().authenticated()
                )

                // Configure form login
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .successHandler(customSuccessHandler)  // Handle successful login
                        .permitAll()
                )

                // Configure logout
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    // Use AuthenticationConfiguration to manage the authentication manager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
