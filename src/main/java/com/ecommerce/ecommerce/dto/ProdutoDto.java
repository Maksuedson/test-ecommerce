package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {

    private UUID id;
    private String nome;
    private String descricao;
    private String codigoBarras;
    private BigDecimal preco;
    private CategoriaDto categoria;
    private BigDecimal estoque;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaModificacao;
}
