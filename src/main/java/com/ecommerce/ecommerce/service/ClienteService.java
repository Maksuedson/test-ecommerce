package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.dto.ClienteDto;

import java.util.List;

public interface ClienteService {

	ClienteDto cadastrar(ClienteDto clienteDto);
	
	ClienteDto buscaClientePorId(Long id);
	
	List<ClienteDto> buscaClientePorNome(String nome);
	
	ClienteDto alterarCliente(Long id, ClienteDto clienteDto);
	
	List<ClienteDto> listaClientes();
	
	void deleteById(Long id);
}
