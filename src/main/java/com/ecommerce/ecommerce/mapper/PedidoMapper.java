package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.controller.request.PedidoRequest;
import com.ecommerce.ecommerce.dto.ItemPedidoDto;
import com.ecommerce.ecommerce.dto.PedidoDto;
import com.ecommerce.ecommerce.entity.ItemPedido;
import com.ecommerce.ecommerce.entity.Pedido;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {

    public static PedidoDto toDto(Pedido pedido) {

        List<ItemPedidoDto> itens = pedido.getItems() != null ? pedido.getItems().stream()
                .map(ItemPedidoMapper::toDto)
                .collect(Collectors.toList()) : null;

        return PedidoDto.builder()
                .id(pedido.getId())
                .cliente(pedido.getCliente())
                .pedidoSituacao(pedido.getPedidoSituacao())
                .pagamento(pedido.getPagamento())
                .usuario(pedido.getUsuario())
                .vendedor(pedido.getVendedor())
                .valorTotal(pedido.getValorTotal())
                .items(itens)
                .dataCadastro(pedido.getDataCadastro())
                .dataUltimaModificacao(pedido.getDataUltimaModificacao())
                .dataCancelamento(pedido.getDataCancelamento())
                .build();
    }

    public static Pedido toEntity(PedidoDto pedidoDto) {

        List<ItemPedido> itens = pedidoDto.getItems() != null ? pedidoDto.getItems().stream()
                .map(ItemPedidoMapper::ToEntity)
                .collect(Collectors.toList()) : null;

        return Pedido.builder()
                .id(pedidoDto.getId())
                .cliente(pedidoDto.getCliente())
                .pedidoSituacao(pedidoDto.getPedidoSituacao())
                .pagamento(pedidoDto.getPagamento())
                .usuario(pedidoDto.getUsuario())
                .vendedor(pedidoDto.getVendedor())
                .valorTotal(pedidoDto.getValorTotal())
                .items(itens)
                .dataCadastro(pedidoDto.getDataCadastro())
                .dataUltimaModificacao(pedidoDto.getDataUltimaModificacao())
                .dataCancelamento(pedidoDto.getDataCancelamento())
                .build();
    }

    public static Pedido toEntity(PedidoRequest request) {

        List<ItemPedido> itens = request.getItems() != null ? request.getItems().stream()
                .map(ItemPedidoMapper::ToEntity)
                .collect(Collectors.toList()) : null;

        return Pedido.builder()
                .id(request.getId())
                .cliente(request.getCliente())
                .pedidoSituacao(request.getPedidoSituacao())
                .pagamento(request.getPagamento())
                .usuario(request.getUsuario())
                .vendedor(request.getVendedor())
                .items(itens)
                .build();
    }

}
