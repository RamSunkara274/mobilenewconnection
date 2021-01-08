
package com.demo.mobile.dto;

public class ResponseDto {

	private int statusCode;
	private String message;
	private int requestId;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return "ResponseDto [statusCode=" + statusCode + ", message=" + message + ", requestId=" + requestId + "]";
	}

}
