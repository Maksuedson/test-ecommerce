package com.ecommerce.ecommerce.service.impl;

import com.ecommerce.ecommerce.controller.request.PedidoRequest;
import com.ecommerce.ecommerce.dto.ClienteDto;
import com.ecommerce.ecommerce.entity.Cliente;
import com.ecommerce.ecommerce.entity.ItemPedido;
import com.ecommerce.ecommerce.entity.Pedido;
import com.ecommerce.ecommerce.dto.PedidoDto;
import com.ecommerce.ecommerce.entity.Produto;
import com.ecommerce.ecommerce.enums.PedidoSituacao;
import com.ecommerce.ecommerce.mapper.ClienteMapper;
import com.ecommerce.ecommerce.mapper.ItemPedidoMapper;
import com.ecommerce.ecommerce.mapper.PedidoMapper;
import com.ecommerce.ecommerce.repository.ClienteRepository;
import com.ecommerce.ecommerce.repository.PedidoRepository;
import com.ecommerce.ecommerce.repository.ProdutoRepository;
import com.ecommerce.ecommerce.service.ClienteService;
import com.ecommerce.ecommerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    public  PedidoServiceImpl(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PedidoDto efetuarPedido(PedidoRequest pedidoRequest) {

        ClienteDto clienteDto = clienteService.buscaClientePorId(pedidoRequest.getCliente().getId());
        Cliente cliente = ClienteMapper.mapToCliente(clienteDto);

        Pedido pedido = PedidoMapper.toEntity(pedidoRequest);

        List<ItemPedido> itens = pedidoRequest.getItems().stream()
                .map(itemPedidoRequest -> {
                    ItemPedido mappedItem = ItemPedidoMapper.ToEntity(itemPedidoRequest);

                            Produto produto = produtoRepository.findById(mappedItem.getProduto().getId())
                                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

                            BigDecimal quantidade = itemPedidoRequest.getQuantidade() != null ? itemPedidoRequest.getQuantidade() : BigDecimal.ZERO;

                            mappedItem.setPreco(produto.getPreco());
                            mappedItem.setQuantidade(quantidade);
                            mappedItem.setDataCadastro(LocalDateTime.now().withNano(0));
                            mappedItem.setProduto(produto);
                            mappedItem.setValorTotal(produto.getPreco().multiply(itemPedidoRequest.getQuantidade()));
                            mappedItem.setPedido(pedido);

                            return mappedItem;
                }).toList();

        BigDecimal totalValorProdutos = calcularTotalValorProdutos(itens);

        pedido.setCliente(cliente);
        pedido.setDataCadastro(LocalDateTime.now().withNano(0));
        pedido.setUsuario("usuario");
        pedido.setVendedor("vendedor");
        pedido.setValorTotal(totalValorProdutos);
        pedido.setPedidoSituacao(PedidoSituacao.PENDENTE);
        pedido.setItems(itens);

        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        return PedidoMapper.toDto(pedidoSalvo);
    }

    @Override
    public PedidoDto buscaVendaPorId(Long id) {
        return null;
    }

    @Override
    public PedidoDto alterarVenda(Long id, PedidoRequest pedidoDto) {
        return null;
    }

    @Override
    public PedidoDto fecharVenda(Long id) {
        return null;
    }

    @Override
    public List<PedidoDto> listaVendas() {
        return null;
    }

    @Override
    public List<PedidoDto> listaVendasPorData(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        return null;
    }

    @Override
    public Long buscaUltimoPedidoPorId() {
        return null;
    }

    @Override
    public void cancelarPedidoPorId(Long id) {

    }

    private BigDecimal calcularTotalValorProdutos(List<ItemPedido> itens) {
        return itens.stream()
                .map(ItemPedido::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
