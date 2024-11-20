package com.CraftCodeSmith.rtc.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.util.MultiValueMap;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

public class JwtHandshakeInterceptor implements HandshakeInterceptor {

    // Called before the handshake is completed
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        URI uri = request.getURI();
        MultiValueMap<String, String> queryParams = UriComponentsBuilder.fromUri(uri).build().getQueryParams();
        String token = queryParams.getFirst("token");

        if (token != null) {
            // Extract and validate the JWT token here
            // Example: You can extract the user from the JWT and set it in the attributes
            // String jwtToken = token.substring(7);  // Remove "Bearer " prefix
            // Validate JWT and extract user or roles
            String username = validateAndExtractUsername(token);  // A method to validate and extract user
            System.out.println("username is " + username);
            if (username != null) {
                // Set username in the WebSocket handshake attributes (accessible during the WebSocket session)
                attributes.put("username", username);
                return true;  // Continue the handshake if validation passes
            }
        }
//testing for git forked
        // If token is invalid or not provided, return false to deny the handshake
        return false;
    }

    // Called after the handshake is completed
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        // Optional: You can log the handshake result or perform any additional cleanup here
    }

    // Method to validate the JWT and extract the username (example implementation)
    public static String validateAndExtractUsername(String token) {
        try {
            // Create a JwtParser using the builder pattern (new method in JJWT 0.11.x+)
//            Claims claims =Jwts.parser()
//                    .build()
//                    .parseSignedClaims(token)
//                    .getPayload();
             String secretKey = "c29tZXRoaXMgaGFyZGNvZGVkY2VydGVzdGFuZCBkYXRhY2VydHM=";
            byte[] keyBytes = Decoders.BASE64.decode(secretKey);
            Claims claims = Jwts.parser().verifyWith(Keys.hmacShaKeyFor(keyBytes)).build().parseSignedClaims(token).getPayload();
            System.out.println(claims+" these are decoded claims ");
            // Return the subject (usually the username)
            return claims.getSubject();  // "sub" claim typically contains the username
        } catch (Exception e) {
            System.out.println("error in extracting claims "+ e);
            // If the token is invalid or cannot be parsed, return null
            return null;
        }
    }
}
