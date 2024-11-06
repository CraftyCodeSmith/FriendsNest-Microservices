package com.craftycodesmith.authservice.entities;

import jakarta.persistence.*;

import java.util.Set;

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

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<UserRoles> userRoles;

    // Getter and Setter for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
