
package com.example.sales.appli.Service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String salesName) {

        SecretKey key = Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(secret)
        );

        return Jwts.builder()
                .subject(salesName)
                .issuedAt(new Date())
                .expiration(
                        new Date(System.currentTimeMillis() + 3600000)
                )
                .signWith(key)
                .compact();
    }

    public String extractSalesName(String token) {

        SecretKey key = Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(secret)
        );

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
