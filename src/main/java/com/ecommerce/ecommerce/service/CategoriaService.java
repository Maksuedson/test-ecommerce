package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.dto.CategoriaDto;
import com.ecommerce.ecommerce.dto.ClienteDto;

import java.util.List;

public interface CategoriaService {

	CategoriaDto cadastrar(CategoriaDto categoriaDto);

	CategoriaDto buscaCategoriaPorId(Long id);
	
	List<CategoriaDto> buscaCategoriaPorNome(String nome);

	CategoriaDto alterarCategoriae(Long id, CategoriaDto categoriaDto);
	
	List<CategoriaDto> listaCategoria();
	
	void deleteById(Long id);
}
