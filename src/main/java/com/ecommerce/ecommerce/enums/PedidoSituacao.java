package com.ecommerce.ecommerce.enums;

public enum PedidoSituacao {
	
	PENDENTE("Pendente"),
	CANCELADO("Cancelado"),
	APROVADO("Aprovado");
	
	private String descricao;

	PedidoSituacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
