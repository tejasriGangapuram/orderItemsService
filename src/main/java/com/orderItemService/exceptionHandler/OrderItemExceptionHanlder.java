package com.orderItemService.exceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.orderItemService.exception.InvalidOrderItemException;
import com.orderItemService.exception.OrderIDCannotNullException;
import com.orderItemService.exception.OrderItemNotFoundException;
import com.orderItemService.exception.ProductCodeNotNullException;
@ControllerAdvice
public class OrderItemExceptionHanlder extends ResponseEntityExceptionHandler{
	 @ExceptionHandler(InvalidOrderItemException.class)
	    public ResponseEntity<Object> handleInvalidOrderItemException(InvalidOrderItemException ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "INVALID ORDER ITEM.");

	        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(OrderItemNotFoundException
	    		.class)
	    public ResponseEntity<Object> handleOrderItemNotFoundException(OrderItemNotFoundException ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "OrderItem NOT FOUND  in DB");

	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }
	    @ExceptionHandler(ProductCodeNotNullException.class)
	    public ResponseEntity<Object> handleProductCodeNotNullException(ProductCodeNotNullException ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "Product Code Cannot be NULL.");

	        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	    }
	    //
	    @ExceptionHandler(OrderIDCannotNullException.class)
	    public ResponseEntity<Object> handleOrderIDCannotNullException(OrderIDCannotNullException ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "ORDER ID Cannot be NULL.");

	        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	    }


}
