package com.miniproject.exception;

@SuppressWarnings("serial")
// Public Class Extending Exception Class
public class InsuredException extends Exception {
	//Instance Variable
	private String message;
	//Parameterized Constructor
	public InsuredException(String msg){
		this.message=msg;
	}
	// toString() Method
	@Override
	public String toString() {
		return "InsuredException [message=" + message + "]";
	}
}
