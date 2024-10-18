package com.craftycodesmith.authservice.services.interfaces;

import com.craftycodesmith.authservice.entities.UsersEntity;

import java.util.List;

public interface IUsersService {

    List<UsersEntity> getAllUsers();

}
