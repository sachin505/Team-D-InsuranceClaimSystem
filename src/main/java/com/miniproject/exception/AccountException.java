package com.miniproject.exception;

public class AccountException extends Exception {
	//Instance Variable
	public String message;
	//Parameterized Constructor
	public AccountException(String msg) {
		this.message=msg;
	}
	// toString() Method
	@Override
	public String toString() {
		return message;
	}
}