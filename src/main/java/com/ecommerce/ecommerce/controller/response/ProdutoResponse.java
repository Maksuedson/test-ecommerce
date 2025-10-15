package com.ecommerce.ecommerce.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponse {

	private UUID id;
	private String nome;
	private String codigoBarras;
	private CategoriaResponse categoria;
	private BigDecimal estoque;
	private BigDecimal preco;
	private LocalDateTime dataCadastro;
}
