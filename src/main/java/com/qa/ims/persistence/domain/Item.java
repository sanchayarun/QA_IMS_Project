package com.qa.ims.persistence.domain;

public class Item {
	
	private Long itemId;
	private String itemName;
	private Double itemPrice;


	
	public Item(Long itemId, String itemName, Double itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
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




	@Override
	public String toString() {
		return "item id=" + itemId + ", item name=" + itemName + ", item price=" + itemPrice;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemPrice == null) ? 0 : itemPrice.hashCode());
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
		Item other = (Item) obj;
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
		return true;
	}
}
