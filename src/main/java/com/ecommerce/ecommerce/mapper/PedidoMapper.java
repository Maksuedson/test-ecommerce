package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.controller.request.PedidoRequest;
import com.ecommerce.ecommerce.dto.ItemPedidoDto;
import com.ecommerce.ecommerce.dto.PedidoDto;
import com.ecommerce.ecommerce.entity.ItemPedido;
import com.ecommerce.ecommerce.entity.Pedido;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class PedidoMapper {

    public static PedidoDto mapToPedidoDto(Pedido pedido) {
        return PedidoDto.builder()
                .id(pedido.getId())
                .cliente(pedido.getCliente())
                .pedidoSituacao(pedido.getPedidoSituacao())
                .usuario(pedido.getUsuario())
                .vendedor(pedido.getVendedor())
                .valorTotal(pedido.getValorTotal())
                .items(mapToItemPedidoDtoList(pedido.getItems()))
                .dataCadastro(pedido.getDataCadastro())
                .dataUltimaModificacao(pedido.getDataUltimaModificacao())
                .dataCancelamento(pedido.getDataCancelamento())
                .build();
    }

    public static Pedido mapToPedido(PedidoDto pedidoDto) {
        Pedido pedido = Pedido.builder()
                .id(pedidoDto.getId())
                .cliente(pedidoDto.getCliente())
                .pedidoSituacao(pedidoDto.getPedidoSituacao())
                .usuario(pedidoDto.getUsuario())
                .vendedor(pedidoDto.getVendedor())
                .valorTotal(pedidoDto.getValorTotal())
                .dataCadastro(pedidoDto.getDataCadastro())
                .dataUltimaModificacao(pedidoDto.getDataUltimaModificacao())
                .dataCancelamento(pedidoDto.getDataCancelamento())
                .build();

        // Mapear os items e setar o pedido em cada item
        List<ItemPedido> items = mapToItemPedidoList(pedidoDto.getItems());
        if (items != null) {
            items.forEach(item -> item.setPedido(pedido));
        }
        pedido.setItems(items);

        return pedido;
    }

    public static Pedido mapToPedidoRequest(PedidoRequest pedidoRequest) {
        Pedido pedido = Pedido.builder()
                .id(pedidoRequest.getId())
                .cliente(pedidoRequest.getCliente())
                .pedidoSituacao(pedidoRequest.getPedidoSituacao())
                .usuario(pedidoRequest.getUsuario())
                .vendedor(pedidoRequest.getVendedor())
                .build();

        // Mapear os items e setar o pedido em cada item
        List<ItemPedido> items = mapToItemPedidoList(pedidoRequest.getItems());
        if (items != null) {
            items.forEach(item -> item.setPedido(pedido));
        }
        pedido.setItems(items);

        return pedido;
    }

    private static List<ItemPedidoDto> mapToItemPedidoDtoList(List<ItemPedido> items) {
        if (items == null) return null;
        return items.stream()
                .map(PedidoMapper::mapToItemPedidoDto)
                .collect(Collectors.toList());
    }

    private static List<ItemPedido> mapToItemPedidoList(List<ItemPedidoDto> itemsDto) {
        if (itemsDto == null) return null;
        return itemsDto.stream()
                .map(PedidoMapper::mapToItemPedido)
                .collect(Collectors.toList());
    }

    private static ItemPedidoDto mapToItemPedidoDto(ItemPedido item) {
        ItemPedidoDto dto = new ItemPedidoDto();
        dto.setId(item.getId());
        dto.setPreco(item.getPreco());
        dto.setDataCadastro(item.getDataCadastro());
        dto.setDataUltimaModificacao(item.getDataUltimaModificacao());
        dto.setQuantidade(item.getQuantidade());
        dto.setProduto(item.getProduto());
        dto.setPedido(null); // Evitar recursão infinita ou você pode incluir o ID se necessário
        return dto;
    }

    private static ItemPedido mapToItemPedido(ItemPedidoDto dto) {
        return ItemPedido.builder()
                .id(dto.getId())
                .preco(dto.getPreco())
                .dataCadastro(dto.getDataCadastro())
                .dataUltimaModificacao(dto.getDataUltimaModificacao())
                .quantidade(dto.getQuantidade())
                .produto(dto.getProduto())
                .pedido(null) // Será setado manualmente após criação do Pedido
                .build();
    }
}
