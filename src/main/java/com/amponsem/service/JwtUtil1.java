//package com.amponsem.service;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.Date;
//
//@Component
//public class JwtUtil {
//    private Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode("your-base64-encoded-secret"));
//
//    public String generateToken(String username) {
//        Claims claims = Jwts.claims().setSubject(username);
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(Date.from(Instant.now()))
//                .setExpiration(Date.from(Instant.now().plus(10, ChronoUnit.HOURS)))
//                .signWith(SignatureAlgorithm.HS256, key)
//                .compact();
//    }
//
//    public Claims extractClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(key)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    public String extractUsername(String token) {
//        return extractClaims(token).getSubject();
//    }
//
//    public boolean isTokenExpired(String token) {
//        return extractClaims(token).getExpiration().before(new Date());
//    }
//
//    public boolean validateToken(String token, String username) {
//        return (extractUsername(token).equals(username) && !isTokenExpired(token));
//    }
//}
