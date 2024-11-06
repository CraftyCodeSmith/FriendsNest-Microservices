package com.craftycodesmith.authservice.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Users") // You can change "users" to your desired table name
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String username;

    //     Uncomment and modify if you want to maintain roleId as a separate column
//    @Column(nullable = false)
//    private Long roleId;

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

    // Many-to-many relationship with Roles (a user can have many roles)
    @ManyToMany
    @JoinTable(
            name = "user_roles", // Join table between Users and Roles
            joinColumns = @JoinColumn(name = "user_id"), // Foreign key to the Users table
            inverseJoinColumns = @JoinColumn(name = "role_id") // Foreign key to the Roles table
    )
    private List<Roles> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    private List<Roles> roles;

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))  // Add "ROLE_" prefix for Spring Security
                .collect(Collectors.toList());
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;  // Assume account is non-expired for now
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Assume account is non-locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Assume credentials are non-expired
    }

    @Override
    public boolean isEnabled() {
        return true;  // Assume the account is enabled
    }
}
