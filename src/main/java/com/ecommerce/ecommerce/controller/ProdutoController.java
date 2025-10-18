package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.controller.response.ProdutoResponse;
import com.ecommerce.ecommerce.dto.ProdutoDto;
import com.ecommerce.ecommerce.mapper.ProdutoMapper;
import com.ecommerce.ecommerce.service.interfaces.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PostMapping("/lista")
    public ResponseEntity<List<ProdutoResponse>> salvarLista(@RequestBody List<ProdutoDto> produtoDto){
        List<ProdutoDto> lista = produtoService.cadastrarLista(produtoDto);

        return new ResponseEntity<>(ProdutoMapper.toResponseList(lista), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProdutoResponse> alterar(@RequestBody ProdutoDto produtoDto){
        ProdutoDto produtoAlterado = produtoService.alterar(produtoDto.getId(), produtoDto);
        ProdutoResponse response = ProdutoMapper.mapToProdutoResponse(produtoAlterado);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> buscarPorId(@PathVariable UUID id){
        return ResponseEntity.ok(produtoService.bucarProdutoPorId(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ProdutoDto>> buscarPorNome(@PathVariable String nome){
        return ResponseEntity.ok(produtoService.buscarProdutoPorNome(nome));
    }

    @GetMapping("/nome-ou-codigo-barras/{nomeOuCodigoBarras}")
    public ResponseEntity<List<ProdutoDto>> buscarProdutoPorNomeOuCodigoBarras(@PathVariable String nomeOuCodigoBarras){
        return ResponseEntity.ok(produtoService.buscarProdutoPorNomeOuCodigoBarras(nomeOuCodigoBarras));
    }

    @GetMapping("/codigo-barra/{codigoBarra}")
    public ResponseEntity<ProdutoDto> buscarPorCodigoBarra(@PathVariable String codigoBarra){
        return ResponseEntity.ok(produtoService.buscarProdutoPorCodigoBarras(codigoBarra));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listar(){
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleta(@PathVariable UUID id){
        produtoService.deleteById(id);
        return ResponseEntity.ok("Produto excluido com sucesso!");
    }

}
