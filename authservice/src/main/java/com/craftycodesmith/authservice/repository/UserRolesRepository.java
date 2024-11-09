package com.craftycodesmith.authservice.repository;

import com.craftycodesmith.authservice.entities.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {
}
