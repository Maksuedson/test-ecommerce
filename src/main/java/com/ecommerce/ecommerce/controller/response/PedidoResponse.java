package com.ecommerce.ecommerce.controller.response;

import com.ecommerce.ecommerce.dto.ClienteDto;
import com.ecommerce.ecommerce.dto.ItemPedidoDto;
import com.ecommerce.ecommerce.entity.Cliente;
import com.ecommerce.ecommerce.entity.Usuario;
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
public class PedidoResponse {
    private static final long serialVersionUID = 1L;

    private Long id;
    private ClienteResponse cliente;
    private PedidoSituacao pedidoSituacao;
    private Pagamento pagamento;
    private UsuarioResponse usuario;
    private String vendedor;
    private BigDecimal valorTotal;
    private List<ItemPedidoResponse> items;
    private LocalDateTime dataCadastro;
}
