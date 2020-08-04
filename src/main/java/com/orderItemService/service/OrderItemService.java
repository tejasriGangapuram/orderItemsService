package com.orderItemService.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orderItemService.dao.OrderItemDAO;
import com.orderItemService.entity.OrderItem;
import com.orderItemService.exception.InvalidOrderItemException;
import com.orderItemService.exception.OrderIDCannotNullException;
import com.orderItemService.exception.OrderItemNotFoundException;
import com.orderItemService.exception.ProductCodeNotNullException;

@Service
public class OrderItemService {
	@Autowired
	OrderItemDAO dao;
	@Autowired
	ObjectMapper objectMapper; 
	Logger LOGGER=LoggerFactory.getLogger(this.getClass());

	//add OrderItem
	public void addOrderItem(OrderItem orderItem) {
		if(null!=orderItem &&null!=orderItem.getProductCode()&&!orderItem.getProductCode().isEmpty())
		{	
			if(null!=orderItem.getOrderId()&&!orderItem.getOrderId().isEmpty()){

				dao.addOrderItem(orderItem);
				LOGGER.info("Added OrderItem Successfully.");
			}else{
				throw new InvalidOrderItemException();
			}
		}else{			
			LOGGER.info("Enter VALID OrderItem");

			throw new InvalidOrderItemException();
		}

	}
	//add OrderItems
	public void addListOrderItem(List<OrderItem> orderItem) {

		for(OrderItem item:orderItem)
		{
			addOrderItem(item);
		}

	}
	//DELETE ORDER ITEM BY PRODUCT CODE
	public void deleteOrderItem(String productCode) {
		if(null!=productCode&&!productCode.isEmpty())
		{
			dao.deleteById(productCode);
			LOGGER.info("Deleted OrderItem , ProductCode: "+productCode+" OrderItem Successfully.");

		}else{

			LOGGER.info("ProductCode cannot be NULL/EMPTY.");
			throw new ProductCodeNotNullException();
		}

	}
	//	DELETE ORDER ITEM BY PRODUCT CODE
	public OrderItem findByProductCode(String productCode) throws JsonProcessingException {
		OrderItem orderItem=null;
		if(null!=productCode&&!productCode.isEmpty())
		{
			Optional<OrderItem> item= dao.findById(productCode);
			if(item.isPresent())
				orderItem= item.get();
			else{
				LOGGER.info("OrderItem with ProductCode "+productCode+" does not exist.");
				throw new OrderItemNotFoundException(productCode);
			}

		}else{
			LOGGER.info("ProductCode cannot be NULL/EMPTY.");
			throw new ProductCodeNotNullException();
		}
		LOGGER.info("OrderItem with ProductCode "+productCode+" is "+objectMapper.writeValueAsString(orderItem));
		return orderItem;

	}
	//FETCH ALL ORDER ITEMS
	public List<OrderItem> findAllOrderItem() {
		List<OrderItem> orderItemList= dao.findAll();
		orderItemList.stream().forEach(s->{
			LOGGER.info("ProductCode :"+s.getProductCode()+"; ProducctName: "+s.getProductName()+"; Quantity : "+s.getQuantity());
		});
		return orderItemList;

	}
	//FETCH BY ORDER ID
	public List<OrderItem> findAllByOrderId(String orderId) {

		List<OrderItem> orderItemList=null;
		if(null!=orderId&&!orderId.isEmpty()){
			orderItemList= dao.findAllByOrderId(orderId);
			orderItemList.stream().forEach(s->{
				LOGGER.info("ProductCode :"+s.getProductCode()+"; ProducctName: "+s.getProductName()+"; Quantity : "+s.getQuantity());
			});
		}else{
			throw new OrderIDCannotNullException();
		}
		return orderItemList;

	}
}
