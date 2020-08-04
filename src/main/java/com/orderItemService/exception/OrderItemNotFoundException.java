package com.orderItemService.exception;

public class OrderItemNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderItemNotFoundException(String productCode){
		super(String.format("OrderItem with Product Code "+productCode+" not found."));
	}
}
