package com.example.config;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.model.UserCustomDetails;

import io.jsonwebtoken.*;



@Component

public class JwtTokenProvider {
    // Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
    private static  String jwtSecret = "hainm";

    //Thời gian có hiệu lực của chuỗi jwt
    private final static long JWT_EXPIRATION = 604800000L;

    // Tạo ra jwt từ thông tin user
   public static String generateToken(Authentication authentication) {
	   UserCustomDetails userPrincipal = (UserCustomDetails) authentication.getPrincipal();

	    Date now = new Date();
	    Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
	
	    return Jwts.builder()
	            .setSubject(String.valueOf(userPrincipal.getId()))
	            .setIssuedAt(new Date())
	            .setExpiration(expiryDate)
	            .signWith(SignatureAlgorithm.HS512, jwtSecret)
	            .compact();
	}

    // Lấy thông tin user từ jwt
   public String getUserNameFromJwtToken(String token) {
       return Jwts.parser()
			                .setSigningKey(jwtSecret)
			                .parseClaimsJws(token)
			                .getBody().getSubject();
   }
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            //log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            //log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            //log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            //log.error("JWT claims string is empty.");
        }
        return false;
    }

	
}