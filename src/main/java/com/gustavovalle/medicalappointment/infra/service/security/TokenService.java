package com.gustavovalle.medicalappointment.infra.service.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.gustavovalle.medicalappointment.infra.models.User;

import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class TokenService {
    @Value("${gustavovalle.jwt.expiration}")
    private String expiration;

    @Value("${gustavovalle.jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {
        String profiles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.joining(", "));

        User user = (User) authentication.getPrincipal();
        Date today = new Date();
        Date expirationDate = new Date(today.getTime() + Long.parseLong(expiration));
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);


        return Jwts.builder()
                .setSubject(user.getId().toString())
                .setExpiration(expirationDate)
				.signWith(key)
                .claim("authorities", profiles)
                .compact();
    }
}
