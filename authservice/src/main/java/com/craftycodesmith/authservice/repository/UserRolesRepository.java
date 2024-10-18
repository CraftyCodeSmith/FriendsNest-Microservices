package com.craftycodesmith.authservice.repository;

import com.craftycodesmith.authservice.entities.UserRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<UserRolesEntity, Long> {
}
