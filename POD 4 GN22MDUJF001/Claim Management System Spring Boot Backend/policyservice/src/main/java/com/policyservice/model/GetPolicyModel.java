package com.policyservice.model;

public class GetPolicyModel {
	
	private String message;

	public GetPolicyModel(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
