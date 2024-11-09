package com.craftycodesmith.authservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Users")
@Validated
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 255, message = "Username must be between 3 and 255 characters")
    @Column(length = 255, nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(length = 255, unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password should have at least 6 characters")
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

    // One-to-many relationship with UserRoles
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserRoles> userRoles;

    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return userRoles.stream()
                .map(userRole -> new SimpleGrantedAuthority("ROLE_" + userRole.getRole().getName()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastPasswordChange() {
        return lastPasswordChange;
    }

    public void setLastPasswordChange(Date lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
    }

    public List<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }
}
