package com.craftycodesmith.authservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "UserRoles")
public class UserRolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UsersEntity user;

    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private RolesEntity role;
}
