package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.controller.response.UsuarioResponse;
import com.ecommerce.ecommerce.dto.UsuarioDto;
import com.ecommerce.ecommerce.mapper.UsuarioMapper;
import com.ecommerce.ecommerce.service.interfaces.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastra(@RequestBody UsuarioDto usuarioDto){
        UsuarioDto user = usuarioService.cadastrar(usuarioDto);
        UsuarioResponse response = UsuarioMapper.toResponse(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
