package com.CraftCodeSmith.rtc.config;

import com.CraftCodeSmith.rtc.filters.JwtAuthenticationFilter;
import com.CraftCodeSmith.rtc.util.JwtHandshakeInterceptor;
import com.CraftCodeSmith.rtc.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
@EnableWebSecurity
@EnableWebSocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private final JwtUtil jwtUtil;  // Add JwtUtil here

    public WebSocketConfig(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;  // Constructor injection for JwtUtil
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/video-websocket")
                .addInterceptors(new JwtHandshakeInterceptor()) // JwtHandshakeInterceptor can be used here
                .setAllowedOrigins("*");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Configure the message broker (adjust prefixes as needed)
        config.enableSimpleBroker("/topic", "/queue");
        config.setApplicationDestinationPrefixes("/app");
        config.setUserDestinationPrefix("/user");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF (WebSocket does not use cookies for security)
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/**").permitAll()  // Allow all HTTP requests (adjust if needed)
                        .anyRequest().authenticated()  // Require authentication for any other requests
                )
                .addFilterBefore(new JwtAuthenticationFilter(authenticationManager, jwtUtil), JwtAuthenticationFilter.class);  // Add custom filter with dependencies

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        return authenticationManagerBuilder.build();
    }
}
