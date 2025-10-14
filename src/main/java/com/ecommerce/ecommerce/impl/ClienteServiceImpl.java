package com.ecommerce.ecommerce.impl;

import com.ecommerce.ecommerce.dto.ClienteDto;
import com.ecommerce.ecommerce.entity.Cliente;
import com.ecommerce.ecommerce.exception.IntegridadeException;
import com.ecommerce.ecommerce.exception.NaoAlteradoException;
import com.ecommerce.ecommerce.exception.NaoEncontradoException;
import com.ecommerce.ecommerce.mapper.ClienteMapper;
import com.ecommerce.ecommerce.repository.ClienteRepository;
import com.ecommerce.ecommerce.service.ClienteService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository clienteRepository;

	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	
	public ClienteDto cadastrar(ClienteDto clienteDto) {

		Cliente cliente = ClienteMapper.mapToCliente(clienteDto);

		cliente.setDataCadastro(LocalDateTime.now().withNano(0));
		Cliente salvaCliente = clienteRepository.save(cliente);
		return ClienteMapper.mapToClienteDto(salvaCliente);
	}


	@Override
	public ClienteDto buscaClientePorId(Long id) {
		Cliente cliente = buscaPorId(id);
		return ClienteMapper.mapToClienteDto(cliente);
	}
	
	@Override
	public ClienteDto alterarCliente(Long id, ClienteDto clienteDto) {
		Cliente cliente = buscaPorId(id);

		if (cliente.getNome().equals(clienteDto.getNome())) {
			throw new NaoAlteradoException("Cliente não foi alterado.");
		}
		
		cliente.setNome(clienteDto.getNome());
		cliente.setDataUltimaModificacao(LocalDateTime.now().withNano(0));
		

		
		Cliente clienteAtualizado = clienteRepository.save(cliente);
		return ClienteMapper.mapToClienteDto(clienteAtualizado);
	}


	@Override
	public List<ClienteDto> listaClientes() {
		List<Cliente> lista = clienteRepository.findAll();

		if (lista.isEmpty()) {
			throw new NaoEncontradoException("Clientes não encontrado!");
		}

		return lista
				.stream()
				.map(ClienteMapper::mapToClienteDto)
				.toList();
	}

	@Override
	public void deleteById(Long id) {
		buscaPorId(id);
		try {
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException ex) {
			throw new IntegridadeException(
					"Não é possível excluir o cliente porque ele está sendo referenciada por outros registros.");
		}
	}
	
	private Cliente buscaPorId(Long id) {
		return clienteRepository
				.findById(id)
				.orElseThrow(
						() -> new NaoEncontradoException("Cliente não existe!"));
	}
	
	@Override
	public List<ClienteDto> buscaClientePorNome(String nome) {
		List<Cliente> clientes = clienteRepository.findByName(nome);
	    if (clientes.isEmpty()) {
	        throw new NaoEncontradoException("Cliente não encontrado!");
	    }
		return clientes.stream()
				.map(ClienteMapper::mapToClienteDto)
				.toList();
	}

	
}
