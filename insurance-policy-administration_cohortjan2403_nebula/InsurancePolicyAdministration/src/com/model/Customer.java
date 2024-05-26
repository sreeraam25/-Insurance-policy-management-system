package com.model;

//import java.util.Date;

public class Customer {
		private String customerId;
		private String customerName;
		private java.sql.Date dob;
		private int age;
		private String gender;
		private String occupation;
		private double annualIncome;
		private String medicalHistory;
		private String address;
		private long phoneNumber;
		private String emailId;
		public String getCustomerId() {
			return customerId;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public java.sql.Date getDob() {
			return dob;
		}
		public void setDob(java.sql.Date dob) {
			this.dob = dob;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getOccupation() {
			return occupation;
		}
		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}
		public double getAnnualIncome() {
			return annualIncome;
		}
		public void setAnnualIncome(double annualIncome) {
			this.annualIncome = annualIncome;
		}
		public String getMedicalHistory() {
			return medicalHistory;
		}
		public void setMedicalHistory(String medicalHistory) {
			this.medicalHistory = medicalHistory;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public long getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(long phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public Customer(String customerId, String customerName, java.sql.Date dob, int age, String gender, String occupation,
				double annualIncome, String medicalHistory, String address, long phoneNumber, String emailId) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.dob = dob;
			this.age = age;
			this.gender = gender;
			this.occupation = occupation;
			this.annualIncome = annualIncome;
			this.medicalHistory = medicalHistory;
			this.address = address;
			this.phoneNumber = phoneNumber;
			this.emailId = emailId;
		}
		public String toString() {
			System.out.print("CUSTOMER_ID: "+customerId+"\nCUSTOMER_NAME: " +customerName+"\nDOB: " +dob+"\nAGE: " +age+"\nGENDER: "+gender+"\nOCCUPATION: " +occupation+"\nANNUAL_INCOME: " +annualIncome+"\nMEDICAL_HISTORY: "+medicalHistory+"\nADDRESS: "+address+"\nPHONE_NUMBER: " +phoneNumber+"\nEMAIL_ID: " +emailId+"\n");
			return "";
		}

		
}
