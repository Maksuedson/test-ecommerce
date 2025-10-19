package com.ecommerce.ecommerce.controller;


import com.ecommerce.ecommerce.dto.Login;
import com.ecommerce.ecommerce.entity.Usuario;
import com.ecommerce.ecommerce.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping("/login")
	public String login(@RequestBody Login login) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
				new UsernamePasswordAuthenticationToken
				(login.login(), login.password());
		
		Authentication authenticate = this.authenticationManager
				.authenticate(usernamePasswordAuthenticationToken);
		
		var usuario = (Usuario) authenticate.getPrincipal();
		
		return tokenService.gerarToken(usuario);
	}
}