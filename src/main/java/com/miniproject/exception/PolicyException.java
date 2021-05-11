package com.miniproject.exception;

@SuppressWarnings("serial")
//Public Class Extending Exception Class
public class PolicyException extends Exception {
	//Instance Variable
	public String message;
	//Parameterized Constructor
	public PolicyException(String msg) {
		this.message=msg;
	}
	// toString() Method
	@Override
	public String toString() {
		return "MyException [message=" + message + "]";
	}
	
}
