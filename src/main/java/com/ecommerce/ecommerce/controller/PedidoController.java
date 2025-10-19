package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.controller.request.PedidoRequest;
import com.ecommerce.ecommerce.controller.response.PedidoResponse;
import com.ecommerce.ecommerce.dto.PedidoDto;
import com.ecommerce.ecommerce.mapper.PedidoMapper;
import com.ecommerce.ecommerce.mapper.ProdutoMapper;
import com.ecommerce.ecommerce.service.interfaces.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> efetuarPedido(@RequestBody PedidoRequest request){
        PedidoDto pedido = pedidoService.efetuarPedido(request);
        return new ResponseEntity<>(PedidoMapper.toResponse(pedido), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscaPedidoPorId(@PathVariable Long id){
        return  ResponseEntity.ok(PedidoMapper.toResponse(pedidoService.buscaPedidoPorId(id)));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> listar(){
        return ResponseEntity.ok(PedidoMapper.toResponse(pedidoService.listaPedidos()));
    }

    @PutMapping
    public ResponseEntity<PedidoResponse> alterarPedido(@RequestBody PedidoRequest request){
        PedidoDto pedido = pedidoService.alterarPedido(request.getId(), request);
        PedidoResponse response = PedidoMapper.toResponse(pedido);
        return ResponseEntity.ok(response);
    }

}
