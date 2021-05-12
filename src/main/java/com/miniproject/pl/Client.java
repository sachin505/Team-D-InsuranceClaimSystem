package com.miniproject.pl;

import com.miniproject.exception.PolicyException;
import com.miniproject.service.UserInterFace;

public class Client {
	
	// main executor method for java
	public static void main(String[] args) {
		
		// creating object for UserInterface class
		UserInterFace userInterfaceObj = new UserInterFace();
		
		// calling welcomeMessage method using object
		userInterfaceObj.welcomeMessage();
		
		// calling loginUser method using object
		userInterfaceObj.loginUser();
		
	}

}
