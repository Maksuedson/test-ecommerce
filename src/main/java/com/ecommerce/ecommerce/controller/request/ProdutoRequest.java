package com.ecommerce.ecommerce.controller.request;

import com.ecommerce.ecommerce.dto.CategoriaDto;
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
public class ProdutoRequest {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String nome;
    private String descricao;
    private String codigoBarras;
    private BigDecimal preco;
    private CategoriaRequest categoria;
    private BigDecimal estoque;
}
