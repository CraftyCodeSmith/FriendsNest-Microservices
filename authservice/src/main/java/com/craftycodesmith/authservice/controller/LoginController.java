package com.craftycodesmith.authservice.controller;

import com.craftycodesmith.authservice.dto.LoginRequest;
import com.craftycodesmith.authservice.services.CustomUserDetailsService;
import com.craftycodesmith.authservice.services.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping()
    public String authenticateUser(@RequestBody @Valid LoginRequest loginRequest) {
        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        // Generate JWT if authentication is successful
        return jwtService.generateToken(customUserDetailsService.loadUserByUsername(loginRequest.getEmail()));
    }
}
