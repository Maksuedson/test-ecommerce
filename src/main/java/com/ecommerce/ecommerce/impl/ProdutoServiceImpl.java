package com.ecommerce.ecommerce.impl;

import com.ecommerce.ecommerce.dto.ProdutoDto;
import com.ecommerce.ecommerce.entity.Produto;
import com.ecommerce.ecommerce.mapper.ProdutoMapper;
import com.ecommerce.ecommerce.repository.ProdutoRepository;
import com.ecommerce.ecommerce.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoDto cadastra(ProdutoDto produtoDto) {
        Produto produto = ProdutoMapper.mapToProduto(produtoDto);
        produto.setDataCadastro(LocalDateTime.now().withNano(0));

        Produto produtoSalvo = produtoRepository.save(produto);
        return ProdutoMapper.mapToProdutoDto(produtoSalvo);
    }

    @Override
    public ProdutoDto bucarProdutoPorId(Long id) {
        return null;
    }

    @Override
    public ProdutoDto alterar(Long id, ProdutoDto produtoDto) {
        return null;
    }

    @Override
    public List<ProdutoDto> buscarProdutoPorNome(String nome) {
        return null;
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
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
