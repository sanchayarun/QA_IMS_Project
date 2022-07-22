package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {

	Item item;
	private Long itemId= 1l;
	private String itemName = "Football";
	private Double itemPrice = 20.99;
	
	@Test
	public void testToString() {
		item = new Item(itemId, itemName, itemPrice);
		assertEquals(("item id:" + item.getItemId() + ", item name:" + item.getItemName() + ", item price:" + item.getItemPrice()), item.toString());
	}
	
	@Test
	public void testGetItemId() {
		item = new Item(itemId, itemName, itemPrice);
		assertEquals(itemId, item.getItemId());
	}
	
	@Test
	public void testGetItemName() {
		item = new Item(itemId, itemName, itemPrice);
		assertEquals(itemName, item.getItemName());
	}
	
	@Test
	public void testGetItemPrice() {
		item = new Item(itemId, itemName, itemPrice);
		assertEquals(itemPrice, item.getItemPrice());
	}
	
	@Test
	public void testSetItemId() {
		item = new Item(itemId, itemName, itemPrice);
		item.setItemId((long) 2);
		assertEquals(itemId, item.getItemId());
	}
	
	@Test
	public void testSetItemName() {
		item = new Item(itemId, itemName, itemPrice);
		item.setItemName("Basketball");
		assertEquals("Basketball", item.getItemName());
	}
	
	@Test
	public void testSetItemPrice() {
		item = new Item(itemId, itemName, itemPrice);
		item.setItemPrice(25.99);
		assertEquals(itemPrice, item.getItemPrice());
	}
}
