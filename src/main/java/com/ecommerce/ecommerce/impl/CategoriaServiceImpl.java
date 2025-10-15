package com.ecommerce.ecommerce.impl;

import com.ecommerce.ecommerce.controller.response.CategoriaResponse;
import com.ecommerce.ecommerce.dto.CategoriaDto;
import com.ecommerce.ecommerce.entity.Categoria;
import com.ecommerce.ecommerce.exception.IntegridadeException;
import com.ecommerce.ecommerce.exception.NaoAlteradoException;
import com.ecommerce.ecommerce.exception.NaoEncontradoException;
import com.ecommerce.ecommerce.mapper.CategoriaMapper;
import com.ecommerce.ecommerce.repository.CategoriaRepository;
import com.ecommerce.ecommerce.service.CategoriaService;
import org.springframework.dao.DataIntegrityViolationException;
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
        Categoria categoria = buscarPorId(id);
        return CategoriaMapper.mapToCategoriaDto(categoria);
    }

    private Categoria buscarPorId(Long id) {
        return categoriaRepository
                .findById(id)
                .orElseThrow(
                        () -> new NaoEncontradoException(String.format("Categorias(s) com id '%s' não encontrada(s)!", id)));
    }

    @Override
    public List<CategoriaDto> buscaCategoriaPorNome(String nome) {
        List<Categoria> lista = categoriaRepository.findByName(nome);

        if (lista.isEmpty()) {
            throw new NaoEncontradoException(String.format("Categorias(s) com nome '%s' não encontrada(s)!", nome));
        }
        return lista.stream()
                .map(CategoriaMapper::mapToCategoriaDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDto alterar(Long id, CategoriaDto categoriaDto) {
        Categoria categoria = buscarPorId(id);

        if (categoria.getNome().equals(categoriaDto.getNome())) {
            throw new NaoAlteradoException("Categoria não foi alterado.");
        }

        categoria.setNome(categoriaDto.getNome());
        categoria.setDataUltimaModificacao(LocalDateTime.now().withNano(0));

        Categoria categoriaAtualizado = categoriaRepository.save(categoria);

        return CategoriaMapper.mapToCategoriaDto(categoriaAtualizado);
    }

    @Override
    public List<CategoriaResponse> listaCategorias() {
        List<Categoria> lista = categoriaRepository.findAll();
        if (lista.isEmpty()){
            throw new NaoEncontradoException("Categorias não encontradas");
        }
        return lista.stream()
                .map(CategoriaMapper::mapToCategoriaLista)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        buscarPorId(id);
        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException ex) {
            throw new IntegridadeException(
                    "Não é possível excluir a categoria porque ele está sendo referenciada por outros registros.");
        }
    }
}
