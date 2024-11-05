package com.craftycodesmith.authservice.services;

import com.craftycodesmith.authservice.entities.Users;
import com.craftycodesmith.authservice.repository.UsersRepository;
import com.craftycodesmith.authservice.services.interfaces.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements IUsersService {

    private final UsersRepository userRepository;

    public UsersService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public Users loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find user by email (which is used as username here)
        Users user = userRepository.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Return UserDetails object which is required by Spring Security
//        return new Users(user.getEmail(), user.getPassword(), user.getRoles());  // You may need to adapt this for your roles/authorities
    }
}
