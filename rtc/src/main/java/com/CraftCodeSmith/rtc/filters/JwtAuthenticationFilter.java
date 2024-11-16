package com.CraftCodeSmith.rtc.filters;

import com.CraftCodeSmith.rtc.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.List;

public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    private JwtUtil jwtUtil = new JwtUtil();

    @Autowired
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        super(authenticationManager);  // Call the parent constructor with the AuthenticationManager
        this.jwtUtil = jwtUtil;  // Inject JwtUtil for JWT handling
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);  // Remove "Bearer " prefix
            String username = jwtUtil.extractUsername(token);  // Extract username from JWT

            if (jwtUtil.validateToken(token)) {
                // Create authentication object and set it to SecurityContext
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        username, null, List.of()  // Add roles if needed
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);  // Set principal in SecurityContext
            }
        }

        chain.doFilter(request, response);  // Proceed with the chain
    }
}
