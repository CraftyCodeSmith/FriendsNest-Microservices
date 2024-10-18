package com.craftycodesmith.authservice.repository;

import com.craftycodesmith.authservice.entities.RolePermissionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionsRepository extends JpaRepository<RolePermissionsEntity, Long> {
}
