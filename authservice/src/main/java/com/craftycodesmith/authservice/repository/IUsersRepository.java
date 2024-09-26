package com.craftycodesmith.authservice.repository;

import com.craftycodesmith.authservice.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsersRepository extends JpaRepository<UsersEntity,Long> {

}
