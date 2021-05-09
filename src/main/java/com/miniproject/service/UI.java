package com.miniproject.service;

import java.util.List;
import java.util.Scanner;

import com.miniproject.dao.UserRoledao;
import com.miniproject.dao.UserRoledaoImpl;
import com.miniproject.service.UserService;
import com.miniproject.service.UserServiceImpl;

public class UI {
	UserService userServiceImpl =new UserServiceImpl();
	Scanner scan=new Scanner(System.in);
	public void welcomeMessage() {
		System.out.println("*************** Welcome to Online Insurance Claim Registration System **************");
	}
	public void loginUser() {
		
		System.out.println("Login");
		System.out.println("Please Enter your Username");
		String username=scan.next();
		
		System.out.println("Please Enter your Password");
		String password=scan.next();
		
		System.out.println("Please choose your UserRole");
		System.out.println("1. Insured 2.Agent 3.Admin");
		int option=scan.nextInt();
		String userrole=null;
		if(option==1) {
			userrole="Insured";
		}
		else if(option==2) {
			userrole="Agent";
		}
		else if(option==3) {
			userrole="Admin";
		}
		else {
			System.out.println("Please choose valid role option");
		}
		
		
		int result=userServiceImpl.userLogin(username, password, userrole);
		if(result==1) {
			System.out.println("Welcome "+username);
			System.out.println("choose any from below");
			System.out.println("1.Create Claim 2.view Claim Status");
			userFunctionalities(scan.nextInt(),username);	
		}
		else {
			System.out.println("Login Failed please check your username and password");
		}
		
	}
	public void userFunctionalities(int choice,String username) {
		if(choice==1) {
			 System.out.println("Your Account number is "+userServiceImpl.getAccountNumber(username));
			int accountNumber=userServiceImpl.getAccountNumber(username);
			int policyNumber=userServiceImpl.userPolicyNumber(accountNumber);
			getDetails(policyNumber);
		}
		else if(choice==2) {
			
		}
	}
	public void getDetails(int policyNumber) {
		String claimReason=null;
		String accidentLocationStreet=null;
		String accidentCity=null;
		String accidentState=null;
		int accidentZip=0;
		String claimType=null;
		System.out.println("Please Enter your Claim Reason");
		scan.nextLine();
		claimReason=scan.nextLine();
		System.out.println("Please Enter your AccidentLocationStreet");
		accidentLocationStreet=scan.next();
		System.out.println("Please Enter your AccidentCity");
		accidentCity=scan.next();
		System.out.println("Please Enter your AccidentState");
		accidentState=scan.next();
		System.out.println("Please Enter your AccidentZip");
		accidentZip=Integer.parseInt(scan.next());
		System.out.println("Please Enter your claimType");
		accidentLocationStreet=scan.next();
		userServiceImpl.createClaim(claimReason, accidentLocationStreet, accidentCity, accidentState, accidentZip, claimType, policyNumber);
		
		
	}
}
