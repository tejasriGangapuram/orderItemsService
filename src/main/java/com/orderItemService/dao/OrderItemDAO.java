package com.orderItemService.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orderItemService.entity.OrderItem;
import com.orderItemService.repository.OrderItemRepository;

@Component
public class OrderItemDAO {
	@Autowired
	OrderItemRepository repository;

	Logger LOGGER=LoggerFactory.getLogger(this.getClass());
	
	public void addOrderItem(OrderItem orderItem) {
		repository.save(orderItem);
		repository.flush();

	}
	public Optional<OrderItem> findById(String productCode){
		return repository.findById(productCode);


	}
	public List<OrderItem> findAll(){
		return repository.findAll();
	}
	public List<OrderItem> findAllByOrderId(String orderId){
		return repository.findByOrderId(orderId);
	}
	

	public void deleteById(String productCode) {
		if(repository.findById(productCode).isPresent())
		{
			repository.deleteById(productCode);
			repository.flush();
		}
		else{
			LOGGER.debug("ProductCode "+productCode+" DOES NOT EXISTS in DB.");
		}
	}




}
