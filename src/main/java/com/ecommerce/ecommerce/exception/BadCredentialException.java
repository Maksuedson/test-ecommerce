package com.ecommerce.ecommerce.exception;

public class BadCredentialException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public BadCredentialException(String mensagem) {
		super(mensagem);
	}

}
