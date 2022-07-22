package com.qa.ims.persistence.domain;

public class Order {

	private Long orderId;
	private Long customerId;
//	private Double totalCost;
	
	
	
	
	
	public Order(Long customerId) {
		super();
		this.customerId = customerId;
	}



	public Order(Long orderId, Long customerId) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
	}



//	public Order(Long orderId,Long customerId, Double totalCost) {
//		super();
//		this.orderId = orderId;
//		this.customerId = customerId;
//		this.totalCost = totalCost;
//	}



	public Long getOrderId() {
		return orderId;
	}



	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}



	public Long getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}



//	public Double getTotalCost() {
//		return totalCost;
//	}
//
//
//
//	public void setTotalCost(Double totalCost) {
//		this.totalCost = totalCost;
//	}


	

	
	
	@Override
	public String toString() {
		return "order id:" + orderId + ", customer id:" + customerId ;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		return result;
	}

	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (getOrderId() == null) {
			if (other.getOrderId() != null)
				return false;
		} else if (!getOrderId().equals(other.getOrderId()))
			return false;
		if (getCustomerId() == null) {
			if (other.getCustomerId() != null)
				return false;
		} else if (!getCustomerId().equals(other.getCustomerId()))
			return false;
		return true;
	}

}
