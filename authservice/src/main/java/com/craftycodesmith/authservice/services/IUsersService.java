package com.craftycodesmith.authservice.services;

import com.craftycodesmith.authservice.entities.UsersEntity;

import java.util.List;
import java.util.Optional;

public interface IUsersService {

    List<UsersEntity> getAllUsers();

}
