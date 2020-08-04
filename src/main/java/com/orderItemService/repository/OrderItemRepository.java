package com.orderItemService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orderItemService.entity.OrderItem;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, String> {
	@Query(value = "SELECT * FROM ORDER_ITEM u WHERE u.ORDER_ID = :ORDER_ID", 
			  nativeQuery = true)
			List<OrderItem> findByOrderId(
					@Param("ORDER_ID") String orderId);
}
