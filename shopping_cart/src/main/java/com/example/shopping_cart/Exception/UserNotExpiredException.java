package com.example.shopping_cart.Exception;

public class UserNotExpiredException extends Exception {

	private static final long serialVersionUID = -470180507998010368L;

	public UserNotExpiredException() {
		super();
	}

	public UserNotExpiredException(final String message) {
		super(message);
	}
}
