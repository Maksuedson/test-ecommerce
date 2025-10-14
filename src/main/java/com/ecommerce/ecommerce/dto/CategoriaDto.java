package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.entity.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CategoriaDto {

    private Long id;
    private String nome;
    private List<Produto> produtos;
}
