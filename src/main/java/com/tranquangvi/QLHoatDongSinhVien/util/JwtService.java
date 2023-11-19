package com.tranquangvi.QLHoatDongSinhVien.util;

import com.tranquangvi.QLHoatDongSinhVien.modules.user.custom.CustomUserDetail;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.services.CustomUserDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.io.Decoders;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
//    @Value("${app.jwt.secret}")
//    private String secretKey;
//    @Value("${app.jwt.expiration}")
//    private long jwtExpiration;
//    @Value("${app.jwt.refresh-token.expiration}")
//    private long refreshExpiration;
    private static final String secretKey = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
    private static final long jwtExpiration = 86400000;
    private static final long refreshExpiration = 604800000;

    public String extractUser(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyByte = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyByte);
    }

    public String generateToken(CustomUserDetail userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userDetails.getUsername());
        return generateToken(claims, userDetails);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            CustomUserDetail userDetails
    ) {
        return buildToken(extraClaims, userDetails, jwtExpiration);
    }

    public String generateRefreshToken(
            CustomUserDetail userDetails
    ) {
        return buildToken(new HashMap<>(), userDetails, refreshExpiration);
    }

    private String buildToken(
            Map<String, Object> extraClaims,
            CustomUserDetail userDetails,
            long expiration
    ) {

        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public boolean isTokenValid(String token, CustomUserDetail userDetails) {
        final String username = extractUser(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
