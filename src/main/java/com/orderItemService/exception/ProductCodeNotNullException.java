package com.orderItemService.exception;

public class ProductCodeNotNullException extends RuntimeException {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public ProductCodeNotNullException(){
	super(String.format("ProductCode cannot be NULL."));
}
}
