/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 15 de jan de 2019
 *
 */
package com.diego.cursomc.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Diego Adriano
 *
 */
@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	public String generatedToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}
	
	public boolean tokenValido(String token) {
		Claims claims = getClaims(token);
		if(claims != null) {
			String userName = claims.getSubject();
			Date exprationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			if(userName != null && exprationDate != null && now.before(exprationDate)) {
				return true;
			}
		}
		return false;
	}
	
	public String getUserName(String token) {
		Claims claims = getClaims(token);
		if(claims != null) {
			return claims.getSubject();
		}
		return null;
	}
	
	private Claims getClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		}catch (Exception e) {
			return null;
		}
	}
	
}
