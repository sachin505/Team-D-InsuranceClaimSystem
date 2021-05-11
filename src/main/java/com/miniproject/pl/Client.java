package com.miniproject.pl;

import com.miniproject.service.UserInterFace;

public class Client {

	public static void main(String[] args){
	
		UserInterFace ui=new UserInterFace();
		ui.welcomeMessage();
		ui.loginUser();
		
	}

}
