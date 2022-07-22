package com.qa.ims.persistence.domain;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrderItemTest {

	OrderItem orderItem;
	private Long orderItemId = 1l;
	private Long fkOrderId = 1l;
	private Long fkItemId = 1l;
	private Long quantity = 1l;
	
	@Test
	public void testToString() {
		orderItem = new OrderItem(orderItemId, fkOrderId, fkItemId, quantity);
		assertEquals(("order item id:" + orderItem.getOrderItemId() + ", order id:" + orderItem.getFkOrderId() + ", item id:" + orderItem.getFkItemId()
				+ ", quantity:" + orderItem.getQuantity()), orderItem.toString());
	}
	
	@Test
	public void testGetOrderItemId() {
		orderItem = new OrderItem(orderItemId, fkOrderId, fkItemId, quantity);
		assertEquals(orderItemId, orderItem.getOrderItemId());
	}
	
	@Test
	public void testGetfkOrderId() {
		orderItem = new OrderItem(orderItemId, fkOrderId, fkItemId, quantity);
		assertEquals(fkOrderId, fkItemId, orderItem.getFkOrderId());
	}
	
	@Test
	public void testGetfkItemId() {
		orderItem = new OrderItem(orderItemId, fkOrderId, fkItemId, quantity);
		assertEquals(quantity, orderItem.getFkItemId());
	}
	
	@Test
	public void testGetQuantity() {
		orderItem = new OrderItem(orderItemId, fkOrderId, fkItemId, quantity);
		assertEquals(quantity, orderItem.getQuantity());
	}
	
	
	@Test
	public void testSetOrderItemId() {
		orderItem = new OrderItem(orderItemId, fkOrderId, fkItemId, quantity);
		orderItem.setOrderItemId(2l);
		assertEquals(orderItemId, orderItem.getOrderItemId());
	}
	
	@Test
	public void testSetFkOrderId() {
		orderItem = new OrderItem(orderItemId, fkOrderId, fkItemId, quantity);
		orderItem.setFkOrderId(2l);
		assertEquals(fkOrderId, orderItem.getFkOrderId());
	}
	
	@Test
	public void testSetFkItemId() {
		orderItem = new OrderItem(orderItemId, fkOrderId, fkItemId, quantity);
		orderItem.setFkItemId(3l);
		assertEquals(fkItemId, orderItem.getFkItemId());
	}
	
	
	@Test
	public void testSetQuantity() {
		orderItem = new OrderItem(orderItemId, fkOrderId, fkItemId, quantity);
		orderItem.setQuantity(2l);
		assertEquals(quantity, orderItem.getQuantity());
	}
	
}
