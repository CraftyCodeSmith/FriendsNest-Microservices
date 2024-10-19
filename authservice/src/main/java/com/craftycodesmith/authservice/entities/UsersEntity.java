package com.craftycodesmith.authservice.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Users") // You can change "users" to your desired table name
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String userName;

    // Uncomment and modify if you want to maintain roleId as a separate column
    // @Column(name = "role_id", nullable = true)
    // private Long roleId;

    @Column(length = 255, unique = true, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(nullable = true)
    private Long documentId;

    @Column(length = 255, nullable = true)
    private String bio;

    @Column(nullable = false)
    private Boolean status = true;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordChange;

    // Relations
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserRolesEntity userRoles;

}
