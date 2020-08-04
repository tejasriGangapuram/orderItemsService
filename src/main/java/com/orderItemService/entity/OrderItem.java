package com.orderItemService.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="OrderItem")
public class OrderItem implements Serializable {
	/**
	 * 
	 */
private static final long serialVersionUID = 1L;

@Id
private String productCode;
@Column(name="orderId",nullable=false)
private String orderId;

public String getOrderId() {
	return orderId;
}

public void setOrderId(String orderId) {
	this.orderId = orderId;
}

@Column(name="productName")
private String productName;

@Column(name="quantity")
private int quantity;

public String getProductCode() {
	return productCode;
}

public void setProductCode(String productCode) {
	this.productCode = productCode;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}


}
