package com.craftycodesmith.authservice.controller;

import com.craftycodesmith.authservice.entities.UsersEntity;
import com.craftycodesmith.authservice.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UsersService userService;

    @Autowired
    public UserController(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UsersEntity> getAllUsers() {
        return userService.getAllUsers();
    }

}