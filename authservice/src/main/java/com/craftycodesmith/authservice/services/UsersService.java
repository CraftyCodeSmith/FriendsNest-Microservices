package com.craftycodesmith.authservice.services;

import com.craftycodesmith.authservice.entities.Users;
import com.craftycodesmith.authservice.repository.UsersRepository;
import com.craftycodesmith.authservice.services.interfaces.IUsersService;
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

}
