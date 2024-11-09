package com.craftycodesmith.authservice.controller;

import com.craftycodesmith.authservice.dto.RegisterRequest;
import com.craftycodesmith.authservice.services.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/register")
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping()
    public String authenticateUser(@RequestBody @Valid RegisterRequest registerRequest) {
        return registerService.registerUser(registerRequest.getUsername(), registerRequest.getEmail(), registerRequest.getPassword());
    }
}
