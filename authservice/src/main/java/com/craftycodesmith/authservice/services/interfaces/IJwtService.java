package com.craftycodesmith.authservice.services.interfaces;

import com.craftycodesmith.authservice.entities.Users;
import io.jsonwebtoken.Claims;

import java.util.Map;
import java.util.function.Function;

public interface IJwtService {

    String extractUsername(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    String generateToken(Users users);

    String generateToken(Map<String, Object> extraClaims, Users users);

    long getExpirationTime();

    boolean isTokenValid(String token, Users users);

}
