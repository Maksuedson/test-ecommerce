package com.ecommerce.ecommerce.service.interfaces;

import com.ecommerce.ecommerce.controller.response.CategoriaResponse;
import com.ecommerce.ecommerce.dto.CategoriaDto;

import java.util.List;

public interface CategoriaService {

	CategoriaDto cadastrar(CategoriaDto categoriaDto);
	List<CategoriaDto> cadastrarLista(List<CategoriaDto> lista);

	CategoriaDto buscaCategoriaPorId(Long id);
	
	List<CategoriaDto> buscaCategoriaPorNome(String nome);

	CategoriaDto alterar(Long id, CategoriaDto categoriaDto);
	
	List<CategoriaResponse> listaCategorias();
	
	void deleteById(Long id);
}
