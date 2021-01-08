package com.demo.mobile.dto;

import java.time.LocalDate;

public interface RequestsProjections {

	public String getCustomerName();

	public String getAdharNumber();

	public String getNewConnectionNumber();

	public String getAddress();

	public String getPlanName();

	public int getRequestId();

	public String getStatus();

	public LocalDate getDate();

}
