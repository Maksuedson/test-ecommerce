
package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.controller.response.CategoriaResponse;
import com.ecommerce.ecommerce.controller.response.ProdutoResponse;
import com.ecommerce.ecommerce.dto.CategoriaDto;
import com.ecommerce.ecommerce.dto.ProdutoDto;
import com.ecommerce.ecommerce.entity.Categoria;
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
		Categoria categoria = produto.getCategoria();

        return ProdutoDto.builder()
        		.id(produto.getId())
        		.nome(produto.getNome())
        		.codigoBarras(produto.getCodigoBarras())
        		.preco(produto.getPreco())
				.categoria(CategoriaDto.builder()
						.id(categoria.getId())
						.nome(categoria.getNome())
						.dataCadastro(categoria.getDataCadastro())
						.build())
				.estoque(produto.getEstoque())
        		.dataCadastro(produto.getDataCadastro())
        		.dataUltimaModificacao(produto.getDataUltimaModificacao())
        		.build();
	}


	public static ProdutoResponse mapToProdutoResponse(ProdutoDto produtoDto) {
		CategoriaDto categoria =null;

		if (produtoDto != null){
			categoria = produtoDto.getCategoria();
		}


		return ProdutoResponse.builder()
				.id(produtoDto.getId())
				.nome(produtoDto.getNome())
				.codigoBarras(produtoDto.getCodigoBarras())
				.preco(produtoDto.getPreco())
				.estoque(produtoDto.getEstoque())
				.categoria(CategoriaResponse.builder()
						.id(categoria.getId())
						.nome(categoria.getNome())
						.dataCadastro(categoria.getDataCadastro())
						.build()
				)
				.dataCadastro(produtoDto.getDataCadastro())
				.build();
	}
}
