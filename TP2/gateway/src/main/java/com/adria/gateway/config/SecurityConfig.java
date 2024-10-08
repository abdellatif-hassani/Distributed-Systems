//package com.adria.gateway.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.web.cors.reactive.CorsConfigurationSource;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.http.HttpMethod;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig {
//
//    @Value("${cors.allowed.origin}")
//    private String allowedOrigin;
//
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        http
//                .cors().configurationSource(corsConfigurationSource()) // Apply CORS configuration
//                .and()
//                .csrf().disable() // Disable CSRF if not needed, or customize
//                .authorizeExchange(exchange -> exchange
//                        .pathMatchers("/MONITORING-SERVICE/ws/**").permitAll()
//                        .pathMatchers("/ws/**").permitAll()
//                        .pathMatchers(HttpMethod.OPTIONS).permitAll()
//                        .pathMatchers("/login/**").permitAll()
//                        .anyExchange().authenticated()
//                )
//                .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt); // Use JWT for OAuth2 resource server
//
//        return http.build();
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList(allowedOrigin));
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//}