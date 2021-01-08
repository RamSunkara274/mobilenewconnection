package com.demo.mobile.dto;

public class ConnectionsDto {

	Long connectionId;
	String number;

	public Long getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(Long connectionId) {
		this.connectionId = connectionId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "ConnectionsDto [connectionId=" + connectionId + ", number=" + number + "]";
	}

}
