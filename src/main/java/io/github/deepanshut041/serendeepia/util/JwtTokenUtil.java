package io.github.deepanshut041.serendeepia.util;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class JwtTokenUtil implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

    private static final long serialVersionUID = 1L;

    private String secret = SecurityConstants.SECRET;

    private long expirationTime = SecurityConstants.EXPIRATION;

    public String createToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + expirationTime * 1000);

        return Jwts.builder()
                .setSubject(userPrincipal.getId() + "")
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .claim("permissions", userPrincipal.getAuthorities())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }

    public String getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
