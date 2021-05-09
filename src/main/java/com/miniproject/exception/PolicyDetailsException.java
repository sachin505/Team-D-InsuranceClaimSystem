package com.miniproject.exception;

public class PolicyDetailsException extends Exception {
	public String message;
	public PolicyDetailsException(String msg) {
		this.message=msg;
	}
	@Override
	public String toString() {
		return "PolicyDetailsException [message=" + message + "]";
	}
	
}
