package com.ecommerce.ecommerce.controller.request;

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
public class ItemPedidoRequest {
    private static final long serialVersionUID = 1L;

    private Long id;
    private BigDecimal preco;
    private BigDecimal quantidade;
    private BigDecimal valorTotal;
    private Produto produto;
}
