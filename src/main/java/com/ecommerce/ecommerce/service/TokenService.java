package com.ecommerce.ecommerce.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.ecommerce.ecommerce.entity.Usuario;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class TokenService {

	private static final String SECRETA = "secreta";

	public String gerarToken(Usuario usuario) {
		return JWT.create()
				.withIssuer("Produtos")
				.withSubject(usuario.getUsername())
				.withClaim("id", usuario.getId())
				.withExpiresAt(dataExpiracao())
				.sign(Algorithm.HMAC256(SECRETA));
				
	}

	public String getSubject(String token) {
		return JWT.require(Algorithm.HMAC256(SECRETA))
				.withIssuer("Produtos")
				.build().verify(token).getSubject();
	}
	
	private Instant dataExpiracao() {
		return LocalDateTime.now()
				//.plusMinutes(10)
				.plusSeconds(60)
				.toInstant(ZoneOffset.of("-03:00"));
	}

}