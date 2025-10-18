package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.controller.request.ClienteRequest;
import com.ecommerce.ecommerce.controller.response.ClienteResponse;
import com.ecommerce.ecommerce.dto.ClienteDto;
import com.ecommerce.ecommerce.mapper.ClienteMapper;
import com.ecommerce.ecommerce.service.interfaces.ClienteService;
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
    public ResponseEntity<ClienteResponse> salvaCliente(@RequestBody ClienteRequest request){
        ClienteDto savedClienteDto = clienteService.cadastrar(ClienteMapper.mapToClienteDto(request));
        return new ResponseEntity<>(ClienteMapper.toResponse(savedClienteDto), HttpStatus.CREATED);
    }

    @PostMapping("/lista")
    public ResponseEntity<List<ClienteDto>> salvarListaClientes(@RequestBody List<ClienteDto> clientesDto){
        List<ClienteDto> clientesSalvos = clienteService.cadastrarLista(clientesDto);
        return new ResponseEntity<>(clientesSalvos, HttpStatus.CREATED);
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

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listaClientes(){
        return ResponseEntity.ok(clienteService.listaClientes());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleta(@PathVariable Long id){
        clienteService.deleteById(id);
        return ResponseEntity.ok("Cliente excluido com sucesso!");
    }
}
