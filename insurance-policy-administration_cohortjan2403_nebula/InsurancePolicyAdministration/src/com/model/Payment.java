package com.model;

import java.sql.Date;

public class Payment {
	
	private String paymentId;
	private String customerId;
	private String allocationId;
	private double premium;
	private Date paymentDate;
	private String paymentMode;
	private int installmentCount;
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
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
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public int getInstallmentCount() {
		return installmentCount;
	}
	public void setInstallmentCount(int installmentCount) {
		this.installmentCount = installmentCount;
	}
	public Payment(String paymentId, String customerId, String allocationId, double premium, Date paymentDate,
			String paymentMode, int installmentCount) {
		super();
		this.paymentId = paymentId;
		this.customerId = customerId;
		this.allocationId = allocationId;
		this.premium = premium;
		this.paymentDate = paymentDate;
		this.paymentMode = paymentMode;
		this.installmentCount = installmentCount;
	}
	public String toString() {
		System.out.println("Payment Id: "+paymentId+"\nCustomer Id: "+customerId+"\nAllocation Id: "+allocationId+"\nPremium: "+premium+"\n Payment Date: "+paymentDate
				+"\nPayment Mode: "+paymentMode+"\nInstallment Count: "+installmentCount);
		return "";
	}
	
}
