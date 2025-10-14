package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.dto.ProdutoDto;

import java.util.List;

public interface ProdutoService {

	ProdutoDto cadastra(ProdutoDto produtoDto);

	ProdutoDto bucarProdutoPorId(Long id);

	ProdutoDto alterar(Long id, ProdutoDto produtoDto);

	List<ProdutoDto> buscarProdutoPorNome(String nome);
	
	ProdutoDto buscarProdutoPorCodigoBarras(String codigoBarras);
	
	List<ProdutoDto> buscarProdutoPorNomeOuCodigoBarras(String nomeOuCodigoBarras);

	List<ProdutoDto> listarProdutos();

	void deleteById(Long id);
}
