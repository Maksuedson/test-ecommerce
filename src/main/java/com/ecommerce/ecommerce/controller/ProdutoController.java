package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.controller.response.ProdutoResponse;
import com.ecommerce.ecommerce.dto.ProdutoDto;
import com.ecommerce.ecommerce.mapper.ProdutoMapper;
import com.ecommerce.ecommerce.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> salvar(@RequestBody ProdutoDto produtoDto){
        ProdutoDto produtoSalvo = produtoService.cadastra(produtoDto);
        ProdutoResponse produtoResponse =  ProdutoMapper.mapToProdutoResponse(produtoSalvo);
        return new ResponseEntity<>(produtoResponse, HttpStatus.CREATED);
    }
}
