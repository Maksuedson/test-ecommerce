package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.controller.request.ItemPedidoRequest;
import com.ecommerce.ecommerce.controller.response.ItemPedidoResponse;
import com.ecommerce.ecommerce.dto.ItemPedidoDto;
import com.ecommerce.ecommerce.entity.ItemPedido;

public class ItemPedidoMapper {

    public static ItemPedido ToEntity (ItemPedidoDto itemPedidoDto){

        return ItemPedido.builder()
                .preco(itemPedidoDto.getPreco())
                .dataCadastro(itemPedidoDto.getDataCadastro())
                .dataUltimaModificacao(itemPedidoDto.getDataUltimaModificacao())
                .quantidade(itemPedidoDto.getQuantidade())
                .valorTotal(itemPedidoDto.getValorTotal())
                .produto(ProdutoMapper.mapToProduto(itemPedidoDto.getProduto()))
                .build();
    }

    public static ItemPedidoResponse ToResponse (ItemPedidoDto itemPedidoDto){

        return ItemPedidoResponse.builder()
                .preco(itemPedidoDto.getPreco())
                .dataCadastro(itemPedidoDto.getDataCadastro())
                .quantidade(itemPedidoDto.getQuantidade())
                .valorTotal(itemPedidoDto.getValorTotal())
                .produto(ProdutoMapper.mapToProdutoResponse(itemPedidoDto.getProduto()))
                .build();
    }

    public static ItemPedidoDto toDto (ItemPedido itemPedido){

        return ItemPedidoDto.builder()
                .preco(itemPedido.getPreco())
                .dataCadastro(itemPedido.getDataCadastro())
                .dataUltimaModificacao(itemPedido.getDataUltimaModificacao())
                .quantidade(itemPedido.getQuantidade())
                .valorTotal(itemPedido.getValorTotal())
                .produto(ProdutoMapper.mapToProdutoDto(itemPedido.getProduto()))
                .build();
    }

    public static ItemPedidoRequest toRequest (ItemPedido itemPedido){

        return ItemPedidoRequest.builder()
                .preco(itemPedido.getPreco())
                .quantidade(itemPedido.getQuantidade())
                .valorTotal(itemPedido.getValorTotal())
                .produto(itemPedido.getProduto())
                .build();
    }

    public static ItemPedido ToEntity (ItemPedidoRequest itemPedidoRequest){

        return ItemPedido.builder()
                .preco(itemPedidoRequest.getPreco())
                .quantidade(itemPedidoRequest.getQuantidade())
                .valorTotal(itemPedidoRequest.getValorTotal())
                .produto(itemPedidoRequest.getProduto())
                .build();
    }

}
