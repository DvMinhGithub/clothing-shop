package com.example.demo.config;

import com.example.demo.enums.TokenType;
import com.example.demo.enums.UserRole;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class JwtUtility implements Serializable {
    @Value("${jwt.accessToken.expiredTime}")
    private long accessTokenExpiredTime;

    @Value("${jwt.refreshToken.expiredTime}")
    private long refreshTokenExpiredTime;

    @Value("${jwt.accessToken.secretKey}")
    private String accessTokenSecret;

    @Value("${jwt.refreshToken.secretKey}")
    private String refreshTokenSecret;

    public long getTokenExpiredTime(String token, TokenType tokenType) {
        Claims claims = extractClaimsFromJwtToken(token, tokenType);
        return claims.getExpiration().getTime();
    }

    private String getTokenSecret(TokenType tokenType) {
        return switch (tokenType) {
            case ACCESS_TOKEN -> accessTokenSecret;
            case REFRESH_TOKEN -> refreshTokenSecret;
        };
    }

    private long getExpiryTime(TokenType tokenType) {
        return switch (tokenType) {
            case ACCESS_TOKEN -> System.currentTimeMillis() + accessTokenExpiredTime;
            case REFRESH_TOKEN -> System.currentTimeMillis() + refreshTokenExpiredTime;
        };
    }

    public String generateToken(String email, TokenType tokenType, List<UserRole> listRole) {
        long expireTime = getExpiryTime(tokenType);
        String tokenSecret = getTokenSecret(tokenType);
        return Jwts.builder()
                .setSubject(email)
                .claim("roles", listRole)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(expireTime))
                .signWith(SignatureAlgorithm.HS512, tokenSecret)
                .compact();
    }

    public boolean validateToken(String token, TokenType tokenType) {
        try {
            String tokenSecret = getTokenSecret(tokenType);
            Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty");
        }
        return false;
    }

    public Claims extractClaimsFromJwtToken(String token, TokenType tokenType) {
        String tokenSecret = getTokenSecret(tokenType);
        return Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token).getBody();
    }
}