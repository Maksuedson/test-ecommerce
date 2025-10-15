package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.controller.response.CategoriaResponse;
import com.ecommerce.ecommerce.dto.CategoriaDto;
import com.ecommerce.ecommerce.mapper.CategoriaMapper;
import com.ecommerce.ecommerce.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> salvaCategoria(@RequestBody CategoriaDto categoriaDto){
        CategoriaDto categoriaSalvo = categoriaService.cadastrar(categoriaDto);
        CategoriaResponse categoriaResponse = CategoriaMapper.mapToCategoriaResponse(categoriaSalvo);
        return new ResponseEntity<>(categoriaResponse, HttpStatus.CREATED);
    }

    @PostMapping("/lista")
    public ResponseEntity<List<CategoriaResponse>> salvarLista(@RequestBody List<CategoriaDto> categoriaResponse){
        List<CategoriaDto> lista = categoriaService.cadastrarLista(categoriaResponse);
        List<CategoriaResponse> categorias = CategoriaMapper.mapToCategoriaResponseLista(lista);
        return new ResponseEntity<>(categorias, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.buscaCategoriaPorId(id));
    }

    @PutMapping
    public ResponseEntity<CategoriaResponse> alterar(@RequestBody CategoriaDto categoriaDto){
        CategoriaDto categoriaAlterado = categoriaService.alterar(categoriaDto.getId(), categoriaDto);
        CategoriaResponse catetoria = CategoriaMapper.mapToCategoriaResponse(categoriaAlterado);
        return ResponseEntity.ok(catetoria);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<CategoriaDto>> buscarCategoriaPorNome(@PathVariable String nome){
        return ResponseEntity.ok(categoriaService.buscaCategoriaPorNome(nome));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> listar(){
        return ResponseEntity.ok(categoriaService.listaCategorias());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleta(@PathVariable Long id){
        categoriaService.deleteById(id);
        return ResponseEntity.ok("Categoria excluido com sucesso!");
    }
}
