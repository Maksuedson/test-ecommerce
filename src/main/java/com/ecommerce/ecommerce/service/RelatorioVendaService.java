package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.entity.Pedido;
import com.ecommerce.ecommerce.report.ItemRelatorioDTO;
import com.ecommerce.ecommerce.report.VendaRelatorioDTO;
import com.ecommerce.ecommerce.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelatorioVendaService {

    private final PedidoRepository pedidoRepository;

    public RelatorioVendaService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<VendaRelatorioDTO> gerarRelatorioVendas() {
        List<Pedido> pedidos = pedidoRepository.findAll(); // pode aplicar filtros de data, situação etc.

        return pedidos.stream().map(pedido -> {
            List<ItemRelatorioDTO> itens = pedido.getItems().stream().map(item -> new ItemRelatorioDTO(
                    item.getProduto().getNome(),
                    item.getPreco(),
                    item.getQuantidade(),
                    item.getValorTotal()
            )).collect(Collectors.toList());

            return new VendaRelatorioDTO(
                    pedido.getId(),
                    pedido.getCliente().getNome(),
                    pedido.getVendedor(),
                    pedido.getDataCadastro(),
                    pedido.getPedidoSituacao().name(),
                    pedido.getPagamento().name(),
                    pedido.getValorTotal(),
                    itens
            );
        }).collect(Collectors.toList());
    }
}
