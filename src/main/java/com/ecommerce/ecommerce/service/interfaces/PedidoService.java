package com.ecommerce.ecommerce.service.interfaces;

import com.ecommerce.ecommerce.controller.request.PedidoRequest;
import com.ecommerce.ecommerce.dto.PedidoDto;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidoService {


	PedidoDto efetuarPedido(PedidoRequest pedidoDto);

	PedidoDto buscaPedidoPorId(Long id);

	PedidoDto alterarVenda(Long id, PedidoRequest pedidoDto);

	PedidoDto fecharVenda(Long id);
	
	List<PedidoDto> listaVendas();
	
	List<PedidoDto> listaVendasPorData(LocalDateTime dataInicial, LocalDateTime dataFinal);
	
	Long buscaUltimoPedidoPorId();
	
	void cancelarPedidoPorId(Long id);
}
