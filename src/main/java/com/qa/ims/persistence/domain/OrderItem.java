package com.qa.ims.persistence.domain;

public class OrderItem {

	private Long orderItemId;
	private Long fkOrderId;
	private Long fkItemId;
	private Long quantity;
	
	
	
	
	public OrderItem(Long fkOrderId, Long fkItemId, Long quantity) {
		super();
		this.fkOrderId = fkOrderId;
		this.fkItemId = fkItemId;
		this.quantity = quantity;
	}




	public OrderItem(Long orderItemId, Long fkOrderId, Long fkItemId, Long quantity) {
		super();
		this.orderItemId = orderItemId;
		this.fkOrderId = fkOrderId;
		this.fkItemId = fkItemId;
		this.quantity = quantity;
	}




	public Long getOrderItemId() {
		return orderItemId;
	}




	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}




	public Long getFkOrderId() {
		return fkOrderId;
	}




	public void setFkOrderId(Long fkOrderId) {
		this.fkOrderId = fkOrderId;
	}




	public Long getFkItemId() {
		return fkItemId;
	}




	public void setFkItemId(Long fkItemId) {
		this.fkItemId = fkItemId;
	}




	public Long getQuantity() {
		return quantity;
	}




	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	
	@Override
	public String toString() {
		return "order item id=" + orderItemId + ", order id=" + fkOrderId + ", item id=" + fkItemId
				+ ", quantity=" + quantity;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fkOrderId == null) ? 0 : fkOrderId.hashCode());
		result = prime * result + ((fkItemId == null) ? 0 : fkItemId.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (getFkOrderId() == null) {
			if (other.getFkOrderId() != null)
				return false;
		} else if (!getFkOrderId().equals(other.getFkOrderId()))
			return false;
		if (getFkItemId() == null) {
			if (other.getFkItemId() != null)
				return false;
		} else if (!getFkItemId().equals(other.getFkItemId()))
			return false;
		if (getQuantity() == null) {
			if (other.getQuantity() != null)
				return false;
		} else if (!getQuantity().equals(other.getQuantity()))
			return false;
		return true;
	}
	
	
}
