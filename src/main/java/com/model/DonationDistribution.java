package com.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class DonationDistribution {

	@Id
	@GeneratedValue
	private int distributionId;
	//private NeedyPeople person;
	//private DonationItem item;
	//private Employee distributedBy;
	private double amountDistributed;
	@NotNull
	private Date dateOfDistribution;
	@NotNull
	private Date approvalOrRejectedDate;
	@Enumerated(EnumType.STRING)
	private DonationDistributionStatus status;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="needy_person_id")
	private NeedyPeople person;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id")
	private Employee distributedBy;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="item_id")
	private DonationItem item;

	// getters and setters
	public int getDistributionId() {
		return distributionId;
	}

	public void setDistributionId(int distributionId) {
		this.distributionId = distributionId;
	}

	public NeedyPeople getPerson() {
		return person;
	}

	public void setPerson(NeedyPeople person) {
		this.person = person;
	}

	public DonationItem getItem() {
		return item;
	}

	public void setItem(DonationItem item) {
		this.item = item;
	}

	public Employee getDistributedBy() {
		return distributedBy;
	}

	public void setDistributedBy(Employee distributedBy) {
		this.distributedBy = distributedBy;
	}

	public double getAmountDistributed() {
		return amountDistributed;
	}

	public void setAmountDistributed(double amountDistributed) {
		this.amountDistributed = amountDistributed;
	}

	public Date getDateOfDistribution() {
		return dateOfDistribution;
	}

	public void setDateOfDistribution(Date dateOfDistribution) {
		this.dateOfDistribution = dateOfDistribution;
	}

	public Date getApprovalOrRejectedDate() {
		return approvalOrRejectedDate;
	}

	public void setApprovalOrRejectedDate(Date approvalOrRejectedDate) {
		this.approvalOrRejectedDate = approvalOrRejectedDate;
	}

	public DonationDistributionStatus getStatus() {
		return status;
	}

	public void setStatus(DonationDistributionStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DonationDistribution [distributionId=" + distributionId + ", person=" + person + ", item=" + item
				+ ", distributedBy=" + distributedBy + ", amountDistributed=" + amountDistributed
				+ ", dateOfDistribution=" + dateOfDistribution + ", approvalOrRejectedDate=" + approvalOrRejectedDate
				+ ", status=" + status + "]";
	}

}
