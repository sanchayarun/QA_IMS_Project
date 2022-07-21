package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrderTest {
	Order order;
	private Long orderId= 1l;
	private Long customerId = 1l;
	
	
	@Test
	public void testToString() {
		order = new Order(orderId, customerId);
		assertEquals(("order id:" + order.getOrderId() + ", customer id:" + order.getCustomerId()), order.toString());
	}
	
	@Test
	public void testGetOrderId() {
		order = new Order(orderId, customerId);
		assertEquals(orderId, order.getOrderId());
	}
	
	@Test
	public void testGetCustomerId() {
		order = new Order(orderId, customerId);
		assertEquals(customerId, order.getCustomerId());
	}
	
	
	@Test
	public void testSetOrderId() {
		order = new Order(orderId, customerId);
		order.setOrderId(2l);
		assertEquals(orderId, order.getOrderId());
	}
	
	@Test
	public void testCustomerId() {
		order = new Order(orderId, customerId);
		order.setCustomerId(3l);
		assertEquals(customerId, order.getCustomerId());
	}
	
	
}
