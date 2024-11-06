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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find the user by username from your data source (e.g., database)
        Users users = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Return the Users object directly, as it already implements UserDetails
        return new User(
                users.getUsername(),
                users.getPassword(),  // hashed password
                users.getAuthorities()  // roles/permissions as granted authorities
        );
    }
}
