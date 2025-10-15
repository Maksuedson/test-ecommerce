package com.ecommerce.ecommerce.impl;

import com.ecommerce.ecommerce.dto.ProdutoDto;
import com.ecommerce.ecommerce.entity.Categoria;
import com.ecommerce.ecommerce.entity.Cliente;
import com.ecommerce.ecommerce.entity.Produto;
import com.ecommerce.ecommerce.exception.NaoAlteradoException;
import com.ecommerce.ecommerce.exception.NaoEncontradoException;
import com.ecommerce.ecommerce.mapper.ProdutoMapper;
import com.ecommerce.ecommerce.repository.CategoriaRepository;
import com.ecommerce.ecommerce.repository.ProdutoRepository;
import com.ecommerce.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        produto.setNome(produtoDto.getNome());
        produto.setCodigoBarras(produtoDto.getCodigoBarras());
        produto.setPreco(produtoDto.getPreco());
        produto.setEstoque(produto.getEstoque());
        produto.setDataUltimaModificacao(LocalDateTime.now().withNano(0));

        Produto produtoAtualizado = produtoRepository.save(produto);

        return ProdutoMapper.mapToProdutoDto(produtoAtualizado);
    }

    @Override
    public List<ProdutoDto> buscarProdutoPorNome(String nome) {
        List<Produto> lista = produtoRepository.findProdutoByName(nome);

        if (lista.isEmpty()) {
            throw new NaoEncontradoException("Produtos não encontrado!");
        }
        return lista.stream()
                .map(ProdutoMapper::mapToProdutoDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProdutoDto buscarProdutoPorCodigoBarras(String codigoBarras) {
        return null;
    }

    @Override
    public List<ProdutoDto> buscarProdutoPorNomeOuCodigoBarras(String nomeOuCodigoBarras) {
        return null;
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

    @Override
    public void deleteById(Long id) {

    }
}
