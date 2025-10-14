package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dto.ClienteDto;
import com.ecommerce.ecommerce.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> buscarClientePorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscaClientePorId(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ClienteDto>> buscarClientePorNome(@PathVariable String nome){
        return ResponseEntity.ok(clienteService.buscaClientePorNome(nome));
    }

    @PutMapping()
    public ResponseEntity<ClienteDto> alteraCliente(@RequestBody ClienteDto clienteDto){
        ClienteDto clienteDtoAtualizado = clienteService.alterarCliente(clienteDto.getId(), clienteDto);
        return ResponseEntity.ok(clienteDtoAtualizado);
    }
}
