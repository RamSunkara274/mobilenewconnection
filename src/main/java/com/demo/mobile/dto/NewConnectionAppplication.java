package com.demo.mobile.dto;

public class NewConnectionAppplication {

	private String customerName;
	private String emailId;
	private String adharNumber;
	private String address;
	private String planName;
	private String newConnectionNumber;
	private String referenceNumber;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getNewConnectionNumber() {
		return newConnectionNumber;
	}

	public void setNewConnectionNumber(String newConnectionNumber) {
		this.newConnectionNumber = newConnectionNumber;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	@Override
	public String toString() {
		return "ConnectionAppplication [customerName=" + customerName + ", emailId=" + emailId + ", adharNumber="
				+ adharNumber + ", address=" + address + ", planName=" + planName + ", newConnectionNumber="
				+ newConnectionNumber + ", referenceNumber=" + referenceNumber + "]";
	}

}
