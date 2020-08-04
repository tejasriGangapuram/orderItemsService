package com.orderItemService.exception;

public class InvalidOrderItemException   extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidOrderItemException(){
		super(String.format("Enter Order Item with Valid details."));
	}
}
