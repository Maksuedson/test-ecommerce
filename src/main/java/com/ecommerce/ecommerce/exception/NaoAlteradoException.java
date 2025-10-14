package com.ecommerce.ecommerce.exception;

public class NaoAlteradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NaoAlteradoException(String mensagem) {
		super(mensagem);
	}

}
