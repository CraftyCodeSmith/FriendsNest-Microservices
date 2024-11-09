package com.craftycodesmith.authservice.repository;

import com.craftycodesmith.authservice.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    // Custom method to find a role by its name
    Optional<Roles> findByName(String name);
}
