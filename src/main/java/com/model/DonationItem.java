package com.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DonationItem {

	@Id
	@GeneratedValue
	private int itemId;
	@Enumerated(EnumType.STRING)
	private DonationType item;
	private String itemDescription;

}
