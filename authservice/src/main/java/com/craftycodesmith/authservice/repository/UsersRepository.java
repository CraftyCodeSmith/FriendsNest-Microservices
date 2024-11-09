package com.craftycodesmith.authservice.repository;

import com.craftycodesmith.authservice.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    // Find a user by their username
    Optional<Users> findByUsername(String username);

    // Find a user by their email
    Optional<Users> findByEmail(String email);
}
