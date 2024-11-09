package com.craftycodesmith.authservice.services;

import com.craftycodesmith.authservice.entities.Users;
import com.craftycodesmith.authservice.repository.UsersRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository userRepository;

    public CustomUserDetailsService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Find the user by email from your data source (e.g., database)
        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // Return the Users object as UserDetails
        return new User(
                user.getUsername(),  // Username
                user.getPassword(),  // Hashed password
                user.getAuthorities()  // Roles/permissions as granted authorities
        );
    }
}