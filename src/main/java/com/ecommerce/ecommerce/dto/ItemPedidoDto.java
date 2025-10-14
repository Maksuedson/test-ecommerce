package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.entity.Pedido;
import com.ecommerce.ecommerce.entity.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ItemPedidoDto {

    private Long id;
    private BigDecimal valorProdutos;
    private BigDecimal valorDesconto;
    private BigDecimal valorAcrescimo;
    private BigDecimal valorTotal;
    private BigDecimal preco;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaModificacao;
    private BigDecimal quantidade;
    private Produto produto;
    private Pedido pedido;
}
