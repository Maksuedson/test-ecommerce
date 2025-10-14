package com.ecommerce.ecommerce.impl;

import com.ecommerce.ecommerce.dto.ProdutoDto;
import com.ecommerce.ecommerce.service.ProdutoService;

import java.util.List;

public class ProdutoServiceImpl implements ProdutoService {
    @Override
    public ProdutoDto cadastra(ProdutoDto produtoDto) {
        return null;
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
