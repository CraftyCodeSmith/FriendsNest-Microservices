package com.craftycodesmith.authservice.repository;

import com.craftycodesmith.authservice.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
