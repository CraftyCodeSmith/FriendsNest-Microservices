package com.craftycodesmith.authservice.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255)
    private String description;

    // One-to-many relationship with UserRoles
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserRoles> userRoles;

    // Getter and Setter methods
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
