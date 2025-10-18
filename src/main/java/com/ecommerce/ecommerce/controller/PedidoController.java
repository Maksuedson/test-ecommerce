package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.controller.request.PedidoRequest;
import com.ecommerce.ecommerce.controller.response.PedidoResponse;
import com.ecommerce.ecommerce.dto.PedidoDto;
import com.ecommerce.ecommerce.mapper.PedidoMapper;
import com.ecommerce.ecommerce.service.interfaces.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
