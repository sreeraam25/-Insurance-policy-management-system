package com.model;

import java.sql.Date;

public class Claim {
	private String claimId;
	private String customerId;
	private String allocationId;
	private String claimType;
	private double claimAmount;
	private Date claimDate;
	public String getClaimId() {
		return claimId;
	}
	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getAllocationId() {
		return allocationId;
	}
	public void setAllocationId(String allocationId) {
		this.allocationId = allocationId;
	}
	public String getClaimType() {
		return claimType;
	}
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
	public double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	public Date getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}
	public Claim(String claimId, String customerId, String allocationId, String claimType, double claimAmount,
			Date claimDate) {
		super();
		this.claimId = claimId;
		this.customerId = customerId;
		this.allocationId = allocationId;
		this.claimType = claimType;
		this.claimAmount = claimAmount;
		this.claimDate = claimDate;
	}
	public String toString() {
		System.out.println("Claim Id: "+claimId+"\nCustomer Id: "+customerId+"\nAllocation Id: "+allocationId+"\nClaim Type: "+claimType+"\nClaim Amount: "+claimAmount+"\nClaim Date: "+claimDate);
		return "";
	}
}
