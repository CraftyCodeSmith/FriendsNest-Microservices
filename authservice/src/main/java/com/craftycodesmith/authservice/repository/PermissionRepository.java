package com.craftycodesmith.authservice.repository;

import com.craftycodesmith.authservice.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {
}
