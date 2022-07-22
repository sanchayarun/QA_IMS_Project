package com.qa.ims.persistence.domain;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CustomerTest {

	Customer customer;
	Long customerId = 1l;
	String firstName = "Alex";
	String lastName = "Gordon";
	

	@Test
	public void testToString() {
		customer = new Customer(customerId, firstName, lastName);
		assertEquals(("customer id:" + customer.getCustomerId() + " first name:" + customer.getFirstName() + " last name:" + customer.getLastName()), customer.toString());
	}
	
	@Test
	public void testGetCustomerId() {
		customer = new Customer(customerId, firstName, lastName);
		assertEquals(customerId, customer.getCustomerId());
	}
	
	@Test
	public void testGetFirstName() {
		customer = new Customer(customerId, firstName, lastName);
		assertEquals(firstName, customer.getFirstName());
	}
	
	@Test
	public void testGetLastName() {
		customer = new Customer(customerId, firstName, lastName);
		assertEquals(lastName, customer.getLastName());
	}
	
	@Test
	public void testSetCustomerId() {
		customer = new Customer(customerId, firstName, lastName);
		customer.setCustomerId(2l);
		assertEquals(customerId, customer.getCustomerId());
	}
	
	@Test
	public void testSetFirstName() {
		customer = new Customer(customerId, firstName, lastName);
		customer.setFirstName("David");
		assertEquals("David", customer.getFirstName());
	}
	
	@Test
	public void testSetLastName() {
		customer = new Customer(customerId, firstName, lastName);
		customer.setLastName("Blake");
		assertEquals("Blake", customer.getLastName());
	}
	

	

}
