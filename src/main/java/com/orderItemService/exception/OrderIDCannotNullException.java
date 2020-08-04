package com.orderItemService.exception;

public class OrderIDCannotNullException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderIDCannotNullException(){
		super(String.format("ORDER ID CANNOT BE NULL."));
	}

}
