package com.ecommerce.ecommerce.service.impl;

import com.ecommerce.ecommerce.dto.ProdutoDto;
import com.ecommerce.ecommerce.entity.Categoria;
import com.ecommerce.ecommerce.entity.Produto;
import com.ecommerce.ecommerce.exception.IntegridadeException;
import com.ecommerce.ecommerce.exception.NaoAlteradoException;
import com.ecommerce.ecommerce.exception.NaoEncontradoException;
import com.ecommerce.ecommerce.mapper.ProdutoMapper;
import com.ecommerce.ecommerce.repository.CategoriaRepository;
import com.ecommerce.ecommerce.repository.ProdutoRepository;
import com.ecommerce.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoDto cadastra(ProdutoDto produtoDto) {
        Produto produto = ProdutoMapper.mapToProduto(produtoDto);
        produto.setDataCadastro(LocalDateTime.now().withNano(0));

        Categoria categoria = categoriaRepository.findById(produtoDto.getCategoria().getId())
                .orElseThrow(() -> new NaoEncontradoException("Categoria não encontrada!"));

        produto.setCategoria(categoria);

        Produto produtoSalvo = produtoRepository.save(produto);
        return ProdutoMapper.mapToProdutoDto(produtoSalvo);
    }

    @Override
    public List<ProdutoDto> cadastrarLista(List<ProdutoDto> lista) {
        return lista.stream()
                .map(this::cadastra)
                .collect(Collectors.toList());
    }

    @Override
    public ProdutoDto bucarProdutoPorId(UUID id) {
        Produto produto = buscarPorId(id);
        return ProdutoMapper.mapToProdutoDto(produto);
    }

    private Produto buscarPorId(UUID id) {
        return produtoRepository
                .findById(id)
                .orElseThrow(
                        () -> new NaoEncontradoException("Produto não encontrado!"));
    }

    @Override
    public ProdutoDto alterar(UUID id, ProdutoDto produtoDto) {
        Produto produto = buscarPorId(id);

        if (produto.getNome().equals(produtoDto.getNome())) {
            throw new NaoAlteradoException("Categoria não foi alterado.");
        }

        Categoria categoria = categoriaRepository.findById(produtoDto.getCategoria().getId())
                .orElseThrow(() -> new NaoEncontradoException("Categoria não encontrada!"));

        produto.setNome(produtoDto.getNome());
        produto.setCodigoBarras(produtoDto.getCodigoBarras());
        produto.setPreco(produtoDto.getPreco());
        produto.setCategoria(categoria);
        produto.setEstoque(produto.getEstoque());
        produto.setDataUltimaModificacao(LocalDateTime.now().withNano(0));

        Produto produtoAtualizado = produtoRepository.save(produto);

        return ProdutoMapper.mapToProdutoDto(produtoAtualizado);
    }

    @Override
    public List<ProdutoDto> buscarProdutoPorNome(String nome) {
        List<Produto> lista = produtoRepository.findProdutoByName(nome);

        if (lista.isEmpty()) {
            throw new NaoEncontradoException(String.format("Produto(s) com nome '%s' não encontrado(s)!", nome));
        }
        return lista.stream()
                .map(ProdutoMapper::mapToProdutoDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProdutoDto buscarProdutoPorCodigoBarras(String codigoBarras) {
        Produto produto = produtoRepository.findProdutoByCodigoBarras(codigoBarras);

        if (produto == null){
            throw new NaoEncontradoException(String.format("Produto com código de barras '%s' não encontrado!", codigoBarras));
        }

        return ProdutoMapper.mapToProdutoDto(produto);
    }

    @Override
    public List<ProdutoDto> buscarProdutoPorNomeOuCodigoBarras(String nomeOuCodigoBarras) {
        List<Produto> lista = produtoRepository.findProdutoByNameOrCodigoBarras(nomeOuCodigoBarras);

        if (lista.isEmpty()) {
            throw new NaoEncontradoException(String.format("Produto(s) com nome '%s' não encontrado(s)!", nomeOuCodigoBarras));
        }
        return lista.stream()
                .map(ProdutoMapper::mapToProdutoDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProdutoDto> listarProdutos() {
        List<Produto> lista = produtoRepository.findAll();

        if (lista.isEmpty()) {
            throw new NaoEncontradoException("Produtos não encontrado!");
        }
        return lista.stream()
                .map(ProdutoMapper::mapToProdutoDto)
                .collect(Collectors.toList());
    }

    public Boolean subtrairEstoque(UUID id, BigDecimal quantidade) {
        Produto produto = buscarPorId(id);

        if (quantidade.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("A quantidade a subtrair deve ser maior que zero.");
        }

        if (produto.getEstoque().compareTo(quantidade) < 0) {
            return false;
        }

        produto.setEstoque(produto.getEstoque().subtract(quantidade));
        produto.setDataUltimaModificacao(LocalDateTime.now().withNano(0));

        produtoRepository.save(produto);

        return true;
    }
    public Boolean somarEstoque(UUID id, BigDecimal quantidade) {
        Produto produto = buscarPorId(id);

        if (quantidade.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("A quantidade a subtrair deve ser maior que zero.");
        }

        if (produto.getEstoque().compareTo(quantidade) < 0) {
            return false;
            //throw new IllegalArgumentException("Estoque insuficiente para subtrair a quantidade desejada.");
        }

        produto.setEstoque(produto.getEstoque().add(quantidade));
        produto.setDataUltimaModificacao(LocalDateTime.now().withNano(0));

        produtoRepository.save(produto);

        return true;
    }


    @Override
    public void deleteById(UUID id) {
        buscarPorId(id);
        try {
            produtoRepository.deleteById(id);
        } catch (DataIntegrityViolationException ex) {
            throw new IntegridadeException(
                    "Não é possível excluir o produto porque ele está sendo referenciada por outros registros.");
        }
    }
}
