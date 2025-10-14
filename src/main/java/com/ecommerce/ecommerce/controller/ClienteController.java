package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dto.ClienteDto;
import com.ecommerce.ecommerce.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteDto> salvaCliente(@RequestBody ClienteDto clienteDto){
        ClienteDto savedClienteDto = clienteService.cadastrar(clienteDto);
        return new ResponseEntity<>(savedClienteDto, HttpStatus.CREATED);
    }
}
