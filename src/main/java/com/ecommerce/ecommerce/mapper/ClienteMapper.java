package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.controller.response.ClienteResponse;
import com.ecommerce.ecommerce.dto.ClienteDto;
import com.ecommerce.ecommerce.entity.Cliente;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ClienteMapper {

	public static Cliente mapToCliente(ClienteDto clienteDto) {
		return new Cliente(
				clienteDto.getId(),
				clienteDto.getNome(),
				clienteDto.getEndereco(),
				clienteDto.getNumero(),
				clienteDto.getBairro(),
				clienteDto.getCep(),
				clienteDto.getCidade(),
				clienteDto.getEstado(),
				clienteDto.getTelefone(),
				clienteDto.getCelular(),
				clienteDto.getEmail(),
				clienteDto.getDataCadastro(),
				clienteDto.getDataUltimaModificacao()
				);
	}

	public static ClienteResponse toResponse(ClienteDto clienteDto) {
		return new ClienteResponse(
				clienteDto.getId(),
				clienteDto.getNome(),
				clienteDto.getEndereco(),
				clienteDto.getNumero(),
				clienteDto.getBairro(),
				clienteDto.getCep(),
				clienteDto.getCidade(),
				clienteDto.getEstado(),
				clienteDto.getTelefone(),
				clienteDto.getCelular(),
				clienteDto.getEmail(),
				clienteDto.getDataCadastro()
		);
	}
	
	public static ClienteDto mapToClienteDto(Cliente cliente) {
		return new ClienteDto(
				cliente.getId(),
				cliente.getNome(),
				cliente.getEndereco(),
				cliente.getNumero(),
				cliente.getBairro(),
				cliente.getCep(),
				cliente.getCidade(),
				cliente.getEstado(),
				cliente.getTelefone(),
				cliente.getCelular(),
				cliente.getEmail(),
				cliente.getDataCadastro(),
				cliente.getDataUltimaModificacao()
				);
	}

}
;