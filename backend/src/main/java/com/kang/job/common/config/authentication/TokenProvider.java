package com.kang.job.common.config.authentication;

import com.kang.job.common.config.JobProfileConfigurationProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.function.Function;

/**
 * @author kanghouchao
 */
@Component
public class TokenProvider {

    private final JobProfileConfigurationProperties properties;

    private static final String USERNAME = "username";
    private static final String AUTHORITIES = "authorities";
    private static final String SECRET_KEY = "c7f1d7e68c56a91e92f3b1c4a3979a93f639946b034ea87b96e5d65eb07888b3";
    private final SecretKey key;

    private final JwtParser parser;

    public TokenProvider(JobProfileConfigurationProperties properties) {
        this.properties = properties;
        this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        this.parser = Jwts.parser()
            .verifyWith(key)
            .build();
    }

    public String generateToken(String username, Collection<? extends GrantedAuthority> authorities) {
        Instant now = Instant.now();
        return Jwts.builder()
            .claims()
            .add(USERNAME, username)
            .add(AUTHORITIES, authorities)
            .and()
            .issuedAt(Date.from(now))
            .expiration(Date.from(now.plusMillis(properties.getLoginTokenExpirationMills())))
            .signWith(key)
            .compact();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = parseToken(token).getPayload();
        return claimsResolver.apply(claims);
    }

    public String extractUsername(String token) {
        return extractClaim(token, claims -> claims.get(USERNAME, String.class));
    }

    public boolean isTokenValid(String token, String username) {
        String extractedUsername = extractUsername(token);
        return username.equals(extractedUsername) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    private Jws<Claims> parseToken(String token) {
        return parser.parseSignedClaims(token);
    }

}