package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.dto.ItemPedidoDto;
import com.ecommerce.ecommerce.entity.ItemPedido;

public class ItemPedidoMapper {

    // Converte de entidade para DTO
    public static ItemPedidoDto toDto(ItemPedido itemPedido) {
        if (itemPedido == null) {
            return null;
        }

        return ItemPedidoDto.builder()
                .id(itemPedido.getId())
                .preco(itemPedido.getPreco())
                .dataCadastro(itemPedido.getDataCadastro())
                .dataUltimaModificacao(itemPedido.getDataUltimaModificacao())
                .quantidade(itemPedido.getQuantidade())
                .produto(itemPedido.getProduto())
                .pedido(itemPedido.getPedido())
                .build();
    }

    // Converte de DTO para entidade
    public static ItemPedido toEntity(ItemPedidoDto dto) {
        if (dto == null) {
            return null;
        }

        return ItemPedido.builder()
                .id(dto.getId())
                .preco(dto.getPreco())
                .dataCadastro(dto.getDataCadastro())
                .dataUltimaModificacao(dto.getDataUltimaModificacao())
                .quantidade(dto.getQuantidade())
                .produto(dto.getProduto())
                .pedido(dto.getPedido())
                .build();
    }
}
