package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.entity.Cliente;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PedidoDto {

    private Long id;
    private Cliente cliente;
    private String usuario;
    private String vendedor;
    private BigDecimal valorProdutos;
    private BigDecimal valorDesconto;
    private BigDecimal valorAcrescimo;
    private BigDecimal valorTotal;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaModificacao;
    private LocalDateTime dataCancelamento;
}
