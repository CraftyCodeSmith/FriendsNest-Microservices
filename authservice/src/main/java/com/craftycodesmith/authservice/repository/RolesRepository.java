package com.craftycodesmith.authservice.repository;

import com.craftycodesmith.authservice.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
}
