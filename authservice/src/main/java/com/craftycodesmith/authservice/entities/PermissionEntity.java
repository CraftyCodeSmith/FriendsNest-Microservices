package com.craftycodesmith.authservice.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Permission")
public class PermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255)
    private String description;

    @OneToMany(mappedBy = "permission", cascade = CascadeType.ALL)
    private Set<RolePermissionsEntity> rolePermissions;

}
