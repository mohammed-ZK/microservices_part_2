package com.example.shopping_cart.Exception;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = -470180507998010368L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(final String message) {
		super(message);
	}
}
