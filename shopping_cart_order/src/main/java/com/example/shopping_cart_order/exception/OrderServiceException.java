package com.example.shopping_cart_order.exception;

public class OrderServiceException extends Exception {

	private static final long serialVersionUID = -470180507998010368L;

	public OrderServiceException() {
		super();
	}

	public OrderServiceException(final String message) {
		super(message);
	}
}
