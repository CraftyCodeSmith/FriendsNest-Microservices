package com.craftycodesmith.authservice.services;

import com.craftycodesmith.authservice.entities.Roles;
import com.craftycodesmith.authservice.entities.UserRoles;
import com.craftycodesmith.authservice.entities.Users;
import com.craftycodesmith.authservice.repository.RolesRepository;
import com.craftycodesmith.authservice.repository.UserRolesRepository;
import com.craftycodesmith.authservice.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegisterService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesRepository roleRepository;

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(String username, String email, String password) {
        // Check if username or email exists
        if (usersRepository.findByUsername(username).isPresent()) {
            return "Username already taken!";
        }

        if (usersRepository.findByEmail(email).isPresent()) {
            return "Email already in use!";
        }

        // Encrypt the password
        String encryptedPassword = passwordEncoder.encode(password);

        // Create new user entity
        Users newUser = new Users();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(encryptedPassword);
        newUser.setLastLogin(new Date());
        newUser.setLastPasswordChange(new Date());

        // Assign a default role (e.g., ROLE_USER)
        Roles userRole = roleRepository.findByName("USER").orElseThrow(() -> new RuntimeException("Role not found"));
        UserRoles userRoles = new UserRoles();
        userRoles.setUser(newUser);
        userRoles.setRole(userRole);

        // Save the user and roles
        usersRepository.save(newUser);
        userRolesRepository.save(userRoles);

        return "User registered successfully!";
    }

}
