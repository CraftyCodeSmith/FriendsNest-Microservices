package com.craftycodesmith.authservice.controller;

import com.craftycodesmith.authservice.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {

    private final UsersService userService;

    @Autowired
    public UserController(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers() {
        return "hello I am a spring-boot application is runnung  ";
    }
}