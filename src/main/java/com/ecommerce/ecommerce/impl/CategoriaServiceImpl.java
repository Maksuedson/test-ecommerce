package com.ecommerce.ecommerce.impl;

import com.ecommerce.ecommerce.dto.CategoriaDto;
import com.ecommerce.ecommerce.entity.Categoria;
import com.ecommerce.ecommerce.mapper.CategoriaMapper;
import com.ecommerce.ecommerce.repository.CategoriaRepository;
import com.ecommerce.ecommerce.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public CategoriaDto cadastrar(CategoriaDto categoriaDto) {
        Categoria categoria = CategoriaMapper.mapToCategoria(categoriaDto);

        categoria.setDataCadastro(LocalDateTime.now().withNano(0));
        Categoria categoriaSalvo = categoriaRepository.save(categoria);
        return CategoriaMapper.mapToCategoriaDto(categoriaSalvo);
    }

    public List<CategoriaDto> cadastrarLista(List<CategoriaDto> lista){
        return lista.stream()
                .map(this::cadastrar)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDto buscaCategoriaPorId(Long id) {
        return null;
    }

    @Override
    public List<CategoriaDto> buscaCategoriaPorNome(String nome) {
        return null;
    }

    @Override
    public CategoriaDto alterarCategoriae(Long id, CategoriaDto categoriaDto) {
        return null;
    }

    @Override
    public List<CategoriaDto> listaCategoria() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
