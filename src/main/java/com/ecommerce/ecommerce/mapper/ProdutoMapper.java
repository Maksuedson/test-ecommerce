
package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.controller.response.ProdutoResponse;
import com.ecommerce.ecommerce.dto.ProdutoDto;
import com.ecommerce.ecommerce.entity.Produto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProdutoMapper {

	public static Produto mapToProduto(ProdutoDto produtoDto) {

		return Produto.builder()
				.id(produtoDto.getId())
				.nome(produtoDto.getNome())
				.codigoBarras(produtoDto.getCodigoBarras())
				.preco(produtoDto.getPreco())
				.estoque(produtoDto.getEstoque())
				.dataCadastro(produtoDto.getDataCadastro())
				.dataUltimaModificacao(produtoDto.getDataUltimaModificacao())
				.build();
	}
	
	public static Produto mapToVendaToProduto(ProdutoDto produtoDto) {
		return Produto.builder()
				.id(produtoDto.getId())
				.nome(produtoDto.getNome())
				.codigoBarras(produtoDto.getCodigoBarras())
				.preco(produtoDto.getPreco())
				.estoque(produtoDto.getEstoque())
				.dataCadastro(produtoDto.getDataCadastro())
				.dataUltimaModificacao(produtoDto.getDataUltimaModificacao())
				.build();
	}

	public static ProdutoDto mapToProdutoDto(Produto produto) {
        return ProdutoDto.builder()
        		.id(produto.getId())
        		.nome(produto.getNome())
        		.codigoBarras(produto.getCodigoBarras())
        		.preco(produto.getPreco())
				.estoque(produto.getEstoque())
        		.dataCadastro(produto.getDataCadastro())
        		.dataUltimaModificacao(produto.getDataUltimaModificacao())
        		.build();
	}


	public static ProdutoResponse mapToProdutoResponse(ProdutoDto produtoDto) {
		return ProdutoResponse.builder()
				.id(produtoDto.getId())
				.nome(produtoDto.getNome())
				.codigoBarras(produtoDto.getCodigoBarras())
				.preco(produtoDto.getPreco())
				.estoque(produtoDto.getEstoque())
				.dataCadastro(produtoDto.getDataCadastro())
				.build();
	}
}
