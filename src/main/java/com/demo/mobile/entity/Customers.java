package com.demo.mobile.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long customerId;
	private String customerName;
	private String emailId;
	private String adharNumber;
	private String address;
	private String planName;
	private String newConnectionNumber;
	private String referenceNumber;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

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

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", customerName=" + customerName + ", emailId=" + emailId
				+ ", adharNumber=" + adharNumber + ", address=" + address + ", planName=" + planName
				+ ", newConnectionNumber=" + newConnectionNumber + ", referenceNumber=" + referenceNumber + "]";
	}

}
