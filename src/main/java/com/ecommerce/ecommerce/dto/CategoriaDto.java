package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDto {

    private Long id;
    private String nome;
    private List<Produto> produtos;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaModificacao;
}
