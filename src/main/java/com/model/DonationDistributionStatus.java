package com.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DonationDistributionStatus {

	@Id
	@GeneratedValue
	private int itemId;
	@Enumerated(EnumType.STRING)
	private DonationType item;
	private String itemDescription;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public DonationType getItem() {
		return item;
	}

	public void setItem(DonationType item) {
		this.item = item;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@Override
	public String toString() {
		return "DonationDistributionStatus [itemId=" + itemId + ", item=" + item + ", itemDescription="
				+ itemDescription + "]";
	}

}
