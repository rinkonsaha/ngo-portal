package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Donation {

	@Id
	@GeneratedValue
	private int donationId;
	private Donor donor;
	private DonationItem item;
	private double donationAmount;
	private Date donationDate;

	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public DonationItem getItem() {
		return item;
	}

	public void setItem(DonationItem item) {
		this.item = item;
	}

	public double getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(double donationAmount) {
		this.donationAmount = donationAmount;
	}

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	@Override
	public String toString() {
		return "Donation [donationId=" + donationId + ", donor=" + donor + ", item=" + item + ", donationAmount="
				+ donationAmount + ", donationDate=" + donationDate + "]";
	}

}
