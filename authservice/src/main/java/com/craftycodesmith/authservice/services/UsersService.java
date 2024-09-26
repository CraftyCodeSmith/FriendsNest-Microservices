package com.craftycodesmith.authservice.services;

import com.craftycodesmith.authservice.entities.UsersEntity;
import com.craftycodesmith.authservice.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements IUsersService{

    @Autowired
    private IUsersRepository usersRepository;

    public List<UsersEntity> getAllUsers() {
        return usersRepository.findAll();
    }
}
