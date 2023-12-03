package com.example.shopping_cart.Exception;

public class ErrorInInsertException extends Exception {

	private static final long serialVersionUID = -470180507998010368L;

	public ErrorInInsertException() {
		super();
	}

	public ErrorInInsertException(final String message) {
		super(message);
	}
}
