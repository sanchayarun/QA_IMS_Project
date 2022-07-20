package com.qa.ims.persistence.domain;

public class Order {

	private Long orderId;
	private Long customerId;
	private Long itemId;
	private String itemName;
	private Double itemPrice;
	private Long quantity;
	private Double totalCost;
	
	
	
	
	public Order(Long customerId) {
		super();
		this.customerId = customerId;
	}



	public Order(Long orderId, Long customerId) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
	}



	public Order(Long customerId, Long itemId, Long quantity) {
		super();
		this.customerId = customerId;
		this.itemId = itemId;
		this.quantity = quantity;
	}



	public Order(Long orderId, Long customerId, Long itemId, String itemName, Double itemPrice, Long quantity,
			Double totalCost) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}



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



	public Long getItemId() {
		return itemId;
	}



	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public Double getItemPrice() {
		return itemPrice;
	}



	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}



	public Long getQuantity() {
		return quantity;
	}



	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}



	public Double getTotalCost() {
		return totalCost;
	}



	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}


	
	@Override
	public String toString() {
		return "order id=" + orderId + ", customer id=" + customerId + ", item id=" + itemId + ", item name="
				+ itemName + ", item price=" + itemPrice + ", quantity=" + quantity + ", total cost=" + totalCost;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemPrice == null) ? 0 : itemPrice.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
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
		if (getItemId() == null) {
			if (other.getItemId() != null)
				return false;
		} else if (!getItemId().equals(other.getItemId()))
			return false;
		if (getItemName() == null) {
			if (other.getItemName() != null)
				return false;
		} else if (!getItemName().equals(other.getItemName()))
			return false;
		if (getItemPrice() == null) {
			if (other.getItemPrice() != null)
				return false;
		} else if (!getItemPrice().equals(other.getItemPrice()))
			return false;
		if (getQuantity() == null) {
			if (other.getQuantity() != null)
				return false;
		} else if (!getQuantity().equals(other.getQuantity()))
			return false;
		if (getTotalCost() == null) {
			if (other.getTotalCost() != null)
				return false;
		} else if (!getTotalCost().equals(other.getTotalCost()))
			return false;
		return true;
	}

}
