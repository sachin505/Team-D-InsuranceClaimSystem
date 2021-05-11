package com.miniproject.exception;

@SuppressWarnings("serial")
//Public Class Extending Exception Class
public class PolicyDetailsException extends Exception {
	//Instance Variable
	public String message;
	//Parameterized Constructor
	public PolicyDetailsException(String msg) {
		this.message=msg;
	}
	// toString() Method
	@Override
	public String toString() {
		return "PolicyDetailsException [message=" + message + "]";
	}
	
}
