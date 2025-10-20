package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.controller.request.LoginRequest;
import com.ecommerce.ecommerce.controller.response.TokenResponse;
import com.ecommerce.ecommerce.controller.response.UsuarioResponse;
import com.ecommerce.ecommerce.dto.UsuarioDto;
import com.ecommerce.ecommerce.entity.Usuario;
import com.ecommerce.ecommerce.infra.security.TokenService;
import com.ecommerce.ecommerce.mapper.UsuarioMapper;
import com.ecommerce.ecommerce.repository.UsuarioRepository;
import com.ecommerce.ecommerce.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioResponse> cadastra(@RequestBody UsuarioDto usuarioDto){
        UsuarioDto user = usuarioService.cadastrar(usuarioDto);
        UsuarioResponse response = UsuarioMapper.toResponse(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new TokenResponse(token));
    }
}
