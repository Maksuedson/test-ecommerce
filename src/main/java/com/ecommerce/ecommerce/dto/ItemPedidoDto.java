package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.entity.Pedido;
import com.ecommerce.ecommerce.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDto {
    private static final long serialVersionUID = 1L;

    private Long id;
    private BigDecimal preco;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaModificacao;
    private BigDecimal quantidade;
    private BigDecimal valorTotal;
    private Produto produto;
    private Pedido pedido;
}
