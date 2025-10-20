package com.ecommerce.ecommerce.exception;

public class SqlInterityContraintViolationException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public SqlInterityContraintViolationException(String mensagem) {
		super(mensagem);
	}

}