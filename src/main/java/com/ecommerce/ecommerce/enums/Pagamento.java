package com.ecommerce.ecommerce.enums;

public enum Pagamento {
	
	    DINHEIRO("Dinheiro"),
	    PIX("PIX"),
	    PRAZO("Prazo"),
	    CARTAO_DEBITO("Débito"),
	    TRANSFERENCIA("Transferência"),
	    CARTAO_1X("Crédito 01 x"),
	    CARTAO_2X("Crédito 02 x"),
	    CARTAO_3X("Crédito 03 x"),
	    CARTAO_4X("Crédito 04 x"),
	    CARTAO_5X("Crédito 05 x"), 
	    CARTAO_6X("Crédito 06 x"),
	    CARTAO_7X("Crédito 07 x"),
	    CARTAO_8X("Crédito 08 x"),
	    CARTAO_9X("Crédito 09 x"),
	    CARTAO_10X("Crédito 10 x"), 
	    CARTAO_11X("Crédito 11 x"),
	    CARTAO_12X("Crédito 12 x") ,
	    CARTAO_13X("Crédito 13 x"),
	    CARTAO_14X("Crédito 14 x"),
	    CARTAO_15X("Crédito 15 x"),
	    CARTAO_16X("Crédito 16 x"),
	    CARTAO_17X("Crédito 17 x"),
	    CARTAO_18X("Crédito 18 x");

	private String descricao;

	Pagamento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
