package com.miniproject.service;

import java.util.List;
import java.util.Scanner;

import com.miniproject.dao.UserRoledao;
import com.miniproject.dao.UserRoledaoImpl;
import com.miniproject.entities.Claim;
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
			if(userrole.equals("Insured")) {
				System.out.println("choose any from below");
				System.out.println("1.Create Claim 2.View Claim Status");
				insuredFunctionalities(scan.nextInt(),username);
			}
			else if(userrole.equals("Agent")) {
				System.out.println("choose any from below");
				System.out.println("1.Create Claim for their customer 2.View Customer's Claims");
				agentFunctionalities(scan.nextInt(),username);
			}
			else {
				System.out.println("choose any from below");
				System.out.println("1.Generate Claim Report 2.Create Role");
				
				
			}
			
				
		}
		else {
			System.out.println("Login Failed please check your username, password and UserRole");
		}
		
	}
	public void insuredFunctionalities(int choice,String username) {
		int accountNumber = 0;
		int policyNumber = 0;
		if(choice==1) {
			System.out.println("Your Account number is "+userServiceImpl.getAccountNumber(username));
			accountNumber=userServiceImpl.getAccountNumber(username);
			policyNumber=userServiceImpl.userPolicyNumber(accountNumber);
			noteClaimDetailsForInsured(policyNumber);
		}
		else if(choice==2) {
			accountNumber=userServiceImpl.getAccountNumber(username);
			policyNumber=userServiceImpl.userPolicyNumber(accountNumber);
			userServiceImpl.getClaim(policyNumber);
		}
	}
	public void noteClaimDetailsForInsured(int policyNumber) {
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
		claimType=scan.next();
		userServiceImpl.createClaim(claimReason, accidentLocationStreet, accidentCity, accidentState, accidentZip, claimType, policyNumber);
	}

	//COMPLETE OF INSURED FUNCTIONALITIES......................
	//BEGIN OF AGENT FUNCTIONALITIES..............
	public void agentFunctionalities(int choice, String agentName) {
		 int accountNumber=0;
		 int policyNumber=0;
		 int isClaimPresent=0;
		if(choice==1) {
			//Create Claim for their customer
			
			System.out.println("Please Enter your Customer's  Username");
			String username=scan.next();
			 int result=userServiceImpl.getAgentName(username,agentName);
			
			 if(result==1) {
				  accountNumber=userServiceImpl.getAccountNumber(username);
				  policyNumber=userServiceImpl.userPolicyNumber(accountNumber);
				  isClaimPresent=userServiceImpl.checkForClaim(policyNumber);
				 if(isClaimPresent==1) {
					 System.out.println("Customer with username : "+username+" having Account Number : "+accountNumber+" Policy Number : "+policyNumber);
					 System.out.println("The Claim Already Exists ");
					 userServiceImpl.getClaim(policyNumber); 
				 }
				 else {
					 noteClaimDetailsForInsured(policyNumber);
				 }
				 
				 
			 }
			 else {
				 System.out.println("no he is not your Customer");
			 }
			
		}
		else if(choice==2) {
			System.out.println("Please Enter your Customer's  Username");
			String username=scan.next();
			 accountNumber=userServiceImpl.getAccountNumber(username);
			 policyNumber=userServiceImpl.userPolicyNumber(accountNumber);
			 System.out.println("Customer with username : "+username+" having Account Number : "+accountNumber+" Policy Number : "+policyNumber);
			 isClaimPresent=userServiceImpl.checkForClaim(policyNumber);
			 if(isClaimPresent==1) {
				 userServiceImpl.getClaim(policyNumber);
			 }
			 else {
				 System.out.println("There is no Claim Generated");
			 }
			  
			 
			
		}else {
			System.out.println("Please Choose Proper option");
	}
	
}//END OF AGENT FUNCTIONALITY
//BEGIN OF ADMIN FUNCTIONALITY
	public void AdminFunctionality() {
		
	}
}


