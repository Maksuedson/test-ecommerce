package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.entity.Cliente;
import com.ecommerce.ecommerce.enums.Pagamento;
import com.ecommerce.ecommerce.enums.PedidoSituacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Cliente cliente;
    private PedidoSituacao pedidoSituacao;
    private Pagamento pagamento;
    private String usuario;
    private String vendedor;
    private BigDecimal valorTotal;
    private List<ItemPedidoDto> items;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaModificacao;
    private LocalDateTime dataCancelamento;
}
