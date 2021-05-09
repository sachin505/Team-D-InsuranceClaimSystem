package com.miniproject.exception;

public class InsuredException extends Exception {
	String message;
	public InsuredException(String msg){
		this.message=msg;
	}
	@Override
	public String toString() {
		return "InsuredException [message=" + message + "]";
	}
}
