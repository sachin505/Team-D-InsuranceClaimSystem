package com.miniproject.exception;

public class PolicyException extends Exception {
	public String message;
	public PolicyException(String msg) {
		this.message=msg;
	}
	@Override
	public String toString() {
		return "MyException [message=" + message + "]";
	}
	
}
