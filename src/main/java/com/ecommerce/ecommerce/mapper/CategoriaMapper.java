package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.controller.response.CategoriaResponse;
import com.ecommerce.ecommerce.dto.CategoriaDto;
import com.ecommerce.ecommerce.entity.Categoria;

public class CategoriaMapper {

    public static Categoria mapToCategoria(CategoriaDto categoriaDto){

        return new Categoria(
                categoriaDto.getId(),
                categoriaDto.getNome(),
                categoriaDto.getProdutos(),
                categoriaDto.getDataCadastro(),
                categoriaDto.getDataUltimaModificacao());
    }

    public static CategoriaDto mapToCategoriaDto(Categoria categoria){

        return new CategoriaDto(
                categoria.getId(),
                categoria.getNome(),
                categoria.getProdutos(),
                categoria.getDataCadastro(),
                categoria.getDataUltimaModificacao());
    }

    public static CategoriaResponse mapToCategoriaLista(Categoria categoria){

        return new CategoriaResponse(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDataCadastro());
    }

    public static CategoriaResponse mapToCategoriaResponse(CategoriaDto categoriaDto){

        return new CategoriaResponse(
                categoriaDto.getId(),
                categoriaDto.getNome(),
                categoriaDto.getDataCadastro());
    }
}
