package com.example.camtermembertest.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "asdkcjkajsdkaslj2fjlksajclk3djkasdc";
    public String createToken(Long memberId, String username) {
        return JWT.create()
                .withSubject("JM")
                .withExpiresAt(new Date(System.currentTimeMillis() + (60000 * 1000)))
                .withClaim("username", username)
                .withClaim("memberId", memberId.toString())
                .sign(Algorithm.HMAC512(SECRET_KEY));
    }

    public String validateToken(String token) {
        System.out.println(token);
        String username =
                JWT.require(Algorithm.HMAC512(SECRET_KEY)).build().verify(token).getClaim("username").asString();
        String memberId =
                JWT.require(Algorithm.HMAC512(SECRET_KEY)).build().verify(token).getClaim("memberId").asString();

        return username + " & " + memberId;
    }
}
