package com.via.foura.app.response;

import java.util.List;

/**
 * @author himadri
 *	
 * this pojo class is the error response entity
 */
public class ErrorResponse {
	private String message;
	private List<String> details;
	private int statusCode;

	public ErrorResponse(int statusCode, String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
