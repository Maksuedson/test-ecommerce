package com.ecommerce.ecommerce.controller.request;

import com.ecommerce.ecommerce.entity.Cliente;
import com.ecommerce.ecommerce.enums.Pagamento;
import com.ecommerce.ecommerce.enums.PedidoSituacao;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PedidoRequest {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Cliente cliente;
    private PedidoSituacao pedidoSituacao;
    private Pagamento pagamento;
    private String usuario;
    private String vendedor;
    private List<ItemPedidoRequest> items;
}
