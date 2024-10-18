package com.craftycodesmith.authservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "RolePermissions")
public class RolePermissionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "permission_id")
    private Long permissionId;

    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private RolesEntity role;

    @ManyToOne
    @JoinColumn(name = "permission_id", insertable = false, updatable = false)
    private PermissionEntity permission;

}
