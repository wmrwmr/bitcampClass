package com.bitcamp.mvc.domain;

import java.util.List;

public class OrderCommand {

	// 제품들
	private List<OrderItem> orderItems;
	// 배송지
	private Address address;

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "OrderCommand [orderItems=" + orderItems + ", address=" + address + "]";
	}

}
