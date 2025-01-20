package com.example.foodieexpress.utility;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Component
public class JwtManager {

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.issuer}")
    private String issuer;

    private final Long expirationTime = 1000L * 60 * 60 * 10; // 10 saatlik geçerlilik süresi

    public String createToken(Long authId) {
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiresAt = new Date(System.currentTimeMillis() + expirationTime);

        Object Algorithm;
        Algorithm algorithm = Algorithm.HMAC512(secretKey);


        return JWT.create()
                .withIssuer(issuer)
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .withClaim("authId", authId)
                .withClaim("key", "JX_15_TJJJ")
                .sign(algorithm);
    }

    public Optional<Long> validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(issuer).build();
            DecodedJWT decodedJWT = verifier.verify(token);

            if (Objects.isNull(decodedJWT)) {
                return Optional.empty();
            }

            Long authId = decodedJWT.getClaim("authId").asLong();
            return Optional.of(authId);
        } catch (Exception e) {
            // Loglama yapılabilir
            return Optional.empty();
        }
    }
}
