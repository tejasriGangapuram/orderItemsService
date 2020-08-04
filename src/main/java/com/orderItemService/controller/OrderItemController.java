package com.orderItemService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.orderItemService.entity.OrderItem;
import com.orderItemService.service.OrderItemService;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
	@Autowired 
	OrderItemService service;
	
	@PostMapping("/add")
	public ResponseEntity<String> addOrderItem(@RequestBody OrderItem orderItem){
		
		service.addOrderItem(orderItem);
		return new ResponseEntity<>(HttpStatus.OK);
		
		
	}
	@PostMapping("/addList")
	public ResponseEntity<String> addOrderItem(@RequestBody List<OrderItem> orderItem){
		
		service.addListOrderItem(orderItem);
		return new ResponseEntity<>(HttpStatus.OK);
		
		
	}
	@GetMapping("/fetchById/{productCode}")
	public ResponseEntity<OrderItem> fetchById(@PathVariable("productCode") String productCode) throws JsonProcessingException{
		
		return new ResponseEntity<OrderItem>(service.findByProductCode(productCode),HttpStatus.OK);
		
		
	}
	@GetMapping("/fetchAll")
	public ResponseEntity<List<OrderItem>> fetchAllOrderItems(){
	
		return new ResponseEntity<List<OrderItem>>(service.findAllOrderItem(),HttpStatus.OK);
		
		
	}
	@GetMapping("/fetchByOrderId/{orderId}")
	public ResponseEntity<List<OrderItem>> fetchByOrderId(@PathVariable("orderId") String orderId){
	
		return new ResponseEntity<List<OrderItem>>(service.findAllByOrderId(orderId),HttpStatus.OK);
		
		
	}

	@PostMapping("/deleteById/{productCode}")
	public ResponseEntity<String> deleteOrderItem(@PathVariable("productCode") String productCode){
		service.deleteOrderItem(productCode);
		return new ResponseEntity<>("",HttpStatus.OK);
		
		
	}
	

}
