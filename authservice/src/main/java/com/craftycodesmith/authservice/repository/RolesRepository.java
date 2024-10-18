package com.craftycodesmith.authservice.repository;

import com.craftycodesmith.authservice.entities.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<RolesEntity, Long> {
}
