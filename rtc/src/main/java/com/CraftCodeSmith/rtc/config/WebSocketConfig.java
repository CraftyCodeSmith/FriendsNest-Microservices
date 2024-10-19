package com.CraftCodeSmith.rtc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/websocket")
//                .setAllowedOrigins("chrome-extension://cbcbkhdmedgianpaifchdaddpnmgnknn", "http://localhost:8080")
//                .withSockJS(); // Optional for fallback

        registry.addEndpoint("/websocket");
        registry.addEndpoint("/websocket").withSockJS();

    }
}
