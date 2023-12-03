package com.example.shopping_cart.Exception;

public class UserNotAuthenticatedException extends Exception {

	private static final long serialVersionUID = -470180507998010368L;

	public UserNotAuthenticatedException() {
		super();
	}

	public UserNotAuthenticatedException(final String message) {
		super(message);
	}
}
