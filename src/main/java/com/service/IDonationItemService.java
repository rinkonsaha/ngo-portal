package com.service;

import java.util.List;

import com.model.DonationItem;

public interface IDonationItemService {
	
	public DonationItem addDonationItem(DonationItem donationItem);

	public List<DonationItem> getDonationItems();

	public DonationItem updateDonationItem(int itemId, DonationItem donationItem);

	public DonationItem removeDonationItem(int itemId);

	public DonationItem getdonationItemById(int itemId);

}
