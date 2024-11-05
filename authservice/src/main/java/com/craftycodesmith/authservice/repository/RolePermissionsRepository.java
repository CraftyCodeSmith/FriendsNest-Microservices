package com.craftycodesmith.authservice.repository;

import com.craftycodesmith.authservice.entities.RolePermissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionsRepository extends JpaRepository<RolePermissions, Long> {
}
