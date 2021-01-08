package com.demo.mobile.dto;

public class AdminValidateRequestDto {
	private int requestId;
	private String status;
	private Long customerId;

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "AdminValidateRequestDto [requestId=" + requestId + ", status=" + status + ", customerId=" + customerId
				+ "]";
	}

}
