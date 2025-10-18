package com.ecommerce.ecommerce.controller.request;

import com.ecommerce.ecommerce.dto.ClienteDto;
import com.ecommerce.ecommerce.dto.UsuarioDto;
import com.ecommerce.ecommerce.entity.Cliente;
import com.ecommerce.ecommerce.entity.Usuario;
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
    private ClienteDto cliente;
    private PedidoSituacao pedidoSituacao;
    private Pagamento pagamento;
    private UsuarioDto usuario;
    private String vendedor;
    private List<ItemPedidoRequest> items;
}
