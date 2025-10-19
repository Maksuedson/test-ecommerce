package com.ecommerce.ecommerce.service.impl;

import com.ecommerce.ecommerce.controller.request.PedidoRequest;
import com.ecommerce.ecommerce.dto.ClienteDto;
import com.ecommerce.ecommerce.dto.ProdutoDto;
import com.ecommerce.ecommerce.dto.UsuarioDto;
import com.ecommerce.ecommerce.entity.*;
import com.ecommerce.ecommerce.dto.PedidoDto;
import com.ecommerce.ecommerce.enums.PedidoSituacao;
import com.ecommerce.ecommerce.exception.NaoEncontradoException;
import com.ecommerce.ecommerce.mapper.*;
import com.ecommerce.ecommerce.repository.ClienteRepository;
import com.ecommerce.ecommerce.repository.PedidoRepository;
import com.ecommerce.ecommerce.repository.ProdutoRepository;
import com.ecommerce.ecommerce.repository.UsuarioRepository;
import com.ecommerce.ecommerce.service.interfaces.ClienteService;
import com.ecommerce.ecommerce.service.interfaces.PedidoService;
import com.ecommerce.ecommerce.service.interfaces.ProdutoService;
import com.ecommerce.ecommerce.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public  PedidoServiceImpl(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PedidoDto efetuarPedido(PedidoRequest pedidoRequest) {

        ClienteDto clienteDto = clienteService.buscaClientePorId(pedidoRequest.getCliente().getId());
        Cliente cliente = ClienteMapper.mapToCliente(clienteDto);

        Pedido pedido = PedidoMapper.toEntity(pedidoRequest);

        UsuarioDto usuarioDto = usuarioService.buscaUsuarioPorId(pedido.getUsuario().getId());
        Usuario usuario = UsuarioMapper.toEntity(usuarioDto);

        List<ItemPedido> itens = pedidoRequest.getItems().stream()
                .map(itemPedidoRequest -> {
                    ItemPedido mappedItem = ItemPedidoMapper.ToEntity(itemPedidoRequest);

                    ProdutoDto produtoDto = produtoService.bucarProdutoPorId(mappedItem.getProduto().getId());
                    Produto produto = ProdutoMapper.mapToProduto(produtoDto);

                            BigDecimal quantidade = itemPedidoRequest.getQuantidade() != null ? itemPedidoRequest.getQuantidade() : BigDecimal.ZERO;
                            boolean estoqueSubtraido = produtoService.subtrairEstoque(mappedItem.getProduto().getId(), quantidade);

                            if (!estoqueSubtraido) {
                                pedido.setPedidoSituacao(PedidoSituacao.CANCELADO);
                            } else{
                                pedido.setPedidoSituacao(PedidoSituacao.PENDENTE);
                            }

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
        pedido.setUsuario(usuario);
        pedido.setVendedor(usuario.getUsername());
        pedido.setValorTotal(totalValorProdutos);
        pedido.setItems(itens);


        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        return PedidoMapper.toDto(pedidoSalvo);
    }

    @Override
    public PedidoDto buscaPedidoPorId(Long id) {
        Pedido pedido = buscaPorId(id);
        return PedidoMapper.toDto(pedido);
    }

    private Pedido buscaPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(
                        () -> new NaoEncontradoException(String.format("Pedido numero '%s' não existe!", id)));
    }

    @Override
    public PedidoDto alterarPedido(Long id, PedidoRequest pedidoRequest) {
        Pedido pedidoExistente = buscaPorId(id);

        ClienteDto clienteDto = clienteService.buscaClientePorId(pedidoRequest.getCliente().getId());
        Cliente cliente = ClienteMapper.mapToCliente(clienteDto);

        UsuarioDto usuarioDto = usuarioService.buscaUsuarioPorId(pedidoRequest.getUsuario().getId());
        Usuario usuario = UsuarioMapper.toEntity(usuarioDto);

        List<ItemPedido> itensAtualizados = pedidoRequest.getItems().stream()
                .map(itemPedidoRequest -> {
                    ItemPedido item = ItemPedidoMapper.ToEntity(itemPedidoRequest);
                    ProdutoDto produtoDto = produtoService.bucarProdutoPorId(item.getProduto().getId());
                    Produto produto = ProdutoMapper.mapToProduto(produtoDto);

                    item.setProduto(produto);
                    item.setPreco(produto.getPreco());

                    BigDecimal quantidade = itemPedidoRequest.getQuantidade() != null
                            ? itemPedidoRequest.getQuantidade()
                            : BigDecimal.ZERO;

                    item.setQuantidade(quantidade);
                    item.setValorTotal(produto.getPreco().multiply(quantidade));
                    item.setDataCadastro(LocalDateTime.now().withNano(0));
                    item.setPedido(pedidoExistente);

                    return item;
                }).collect(Collectors.toCollection(ArrayList::new));

        BigDecimal novoValorTotal = calcularTotalValorProdutos(itensAtualizados);

        pedidoExistente.setCliente(cliente);
        pedidoExistente.setUsuario(usuario);
        pedidoExistente.setVendedor(usuario.getUsername());
        pedidoExistente.setPedidoSituacao(pedidoRequest.getPedidoSituacao());
        pedidoExistente.setPagamento(pedidoRequest.getPagamento());

        pedidoExistente.getItems().clear();
        pedidoExistente.getItems().addAll(itensAtualizados);

        pedidoExistente.setValorTotal(novoValorTotal);
        pedidoExistente.setDataUltimaModificacao(LocalDateTime.now().withNano(0));

        Pedido pedidoSalvo = pedidoRepository.save(pedidoExistente);

        return PedidoMapper.toDto(pedidoSalvo);
    }

    @Override
    public PedidoDto fecharVenda(Long id) {
        return null;
    }

    @Override
    public List<PedidoDto> listaPedidos() {
        List<Pedido> lista = pedidoRepository.findAll();

        if (lista.isEmpty()){
            throw new NaoEncontradoException("Pedidos não encontrados");
        }
        return lista.stream()
                .map(PedidoMapper::toDto)
                .collect(Collectors.toList());
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
