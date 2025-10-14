package com.ecommerce.ecommerce.exception;

public class NaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NaoEncontradoException(String mensagem) {
		super(mensagem);
	}

}
