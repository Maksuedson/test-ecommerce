package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.dto.ProdutoDto;
import com.ecommerce.ecommerce.entity.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProdutoService {

	ProdutoDto cadastra(ProdutoDto produtoDto);

	List<ProdutoDto> cadastrarLista(List<ProdutoDto> lista);

	ProdutoDto bucarProdutoPorId(UUID id);

	ProdutoDto alterar(UUID id, ProdutoDto produtoDto);

	List<ProdutoDto> buscarProdutoPorNome(String nome);
	
	ProdutoDto buscarProdutoPorCodigoBarras(String codigoBarras);
	
	List<ProdutoDto> buscarProdutoPorNomeOuCodigoBarras(String nomeOuCodigoBarras);

	List<ProdutoDto> listarProdutos();

	void deleteById(UUID id);

	Boolean subtrairEstoque(UUID id, BigDecimal quantidade);
}
