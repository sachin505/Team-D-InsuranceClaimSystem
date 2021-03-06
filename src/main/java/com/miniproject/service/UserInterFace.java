package com.miniproject.service;

import java.util.Scanner;
import org.apache.log4j.Logger;
import com.miniproject.entities.Account;
import com.miniproject.entities.UserRole;
import com.miniproject.exception.AccountException;
import com.miniproject.exception.PolicyException;

public class UserInterFace {
	
	//Creating Loggers Object
	static Logger log = Logger.getLogger(UserInterFace.class.getName());
	static Logger log2 = Logger.getLogger(UserInterFace.class.getName());
	
	//Creating a reference variable for Interface 
	UserService userServiceImpl =new UserServiceImpl();
	
	//Creating Scanner Object
	Scanner scan=new Scanner(System.in);
	
	//Creating a method to print Welcome Message
	public void welcomeMessage() {
		System.out.println("*************** Welcome to Online Insurance Claim Registration System **************");
	}
	
	//Creating a method for All Project Functionalities
	public void loginUser()  {
		System.out.println("Login");
		System.out.println("Please Enter your Username");
		
		//Storing UserName from console
		String username=scan.next();
		
		System.out.println("Please Enter your Password");
		
		//Storing password from console
		String password=scan.next();
		
		System.out.println("Please choose your UserRole");
		System.out.println("1. Insured 2.Agent 3.Admin");
		
		//Storing the UserRole in Option
		int option=scan.nextInt();
		String userrole=null;
		
		//Using If else for choosing the userRole
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
		
		//Storing the data in result 
		int result=userServiceImpl.userLogin(username, password, userrole);
		
		//Using If Else for letting users to select what they need to see the information
		if(result==1) {
			log.info(username+" added");
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
				adminFunctionality(scan.nextInt());
			}
		}
		else {
			log.error("Login failed for "+username); //Using Loggers Method
			System.out.println("Login Failed please check your username, password and UserRole");
		}
		
	}
	
	//Writing all the Insured Functionalities
	public void insuredFunctionalities(int choice,String username){
		int accountNumber = 0;
		int policyNumber = 0;
		if(choice==1) {
			
			try {
				accountNumber=userServiceImpl.getAccountNumber(username);
			} catch (AccountException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
				return;
			}
			try {
			policyNumber=userServiceImpl.userPolicyNumber(accountNumber);
			}
			catch(PolicyException e) {
				System.out.println(e);
				return;
			}
			int isClaimPresent=userServiceImpl.checkForClaim(policyNumber);
			if(isClaimPresent==0) {
			noteClaimDetailsForInsured(policyNumber);
			}
			else {
				System.out.println("Claim is Already created on this "+policyNumber+" PolicyNumber");
			}
		}
		else if(choice==2) {
			
			try {
				accountNumber=userServiceImpl.getAccountNumber(username);
			} catch (AccountException e1) {
				//  catch block
				System.out.println(e1);
				return;
			}
			try {
			policyNumber=userServiceImpl.userPolicyNumber(accountNumber);
			}catch(PolicyException e) {
				System.out.println(e);
			}
			userServiceImpl.getClaim(policyNumber);
		}
		else {
			System.out.println("Please select proper option");
		}
	}
	
	// Storing all the Claim Details for Insured based on Policy Number
	public void noteClaimDetailsForInsured(int policyNumber) {
		String claimReason=null;
		String accidentLocationStreet=null;
		String accidentCity=null;
		String accidentState=null;
		int accidentZip=0;
		String claimType=null;
		scan.nextLine();
		System.out.println("Please Enter your Claim Reason");
		claimReason=scan.nextLine();
		System.out.println("Please Enter your AccidentLocationStreet");
		accidentLocationStreet=scan.nextLine();
		System.out.println("Please Enter your AccidentCity");
		accidentCity=scan.nextLine();
		System.out.println("Please Enter your AccidentState");
		accidentState=scan.nextLine();
		System.out.println("Please Enter your AccidentZip");
		accidentZip=0;
		int i=0;
		while(i==0) {
		try {
		accidentZip=Integer.parseInt(scan.next());
		i=1;
		}
		catch(NumberFormatException e) {
			System.out.println("Input Type MisMatch please Enter a Number");
		}
		}
		scan.nextLine();
		System.out.println("Please Enter your claimType");
		claimType=scan.nextLine();
		userServiceImpl.createClaim(claimReason, accidentLocationStreet, accidentCity, accidentState, accidentZip, claimType, policyNumber);
	}

	//COMPLETE OF INSURED FUNCTIONALITIES......................
	
	//Writing all theAgent Functionalities
	public void agentFunctionalities(int choice, String agentName) {
		 int accountNumber=0;
		 int policyNumber=0;
		 int isClaimPresent=0;
		 
		 // Using If else for Choosing his role
		if(choice==1) {
			//Create Claim for their customer
			userServiceImpl.getCustomersByAgent(agentName);
			System.out.println("Please Enter your Customer's Username");
			String username=scan.next();
			 int result=userServiceImpl.getAgentName(username,agentName);
			 if(result==1) {
				 
				  try {
					accountNumber=userServiceImpl.getAccountNumber(username);
				} catch (AccountException e1) {
					System.out.println(e1);
					return;
				}
				  try {
				  policyNumber=userServiceImpl.userPolicyNumber(accountNumber);
				  }catch(PolicyException e) {
					  System.out.println(e);
					  return;
				  }
				  isClaimPresent=userServiceImpl.checkForClaim(policyNumber);
				  
				 if(isClaimPresent==1) {
					 System.out.println("Customer with username : "+username+" having Account Number : "+accountNumber+" Policy Number : "+policyNumber);
					 System.out.println("The Claim Already Exists ");
					 userServiceImpl.getClaim(policyNumber); 
				 }
				 else {
					 noteClaimDetailsForInsured(policyNumber);
					 log2.debug("Claim created :"+policyNumber);
				 }
			 }
			 else {
				 System.out.println("Please enter your customers name");
			 }
		}
		else if(choice==2) {
			 userServiceImpl.getCustomersByAgent(agentName);
			 System.out.println("Please Enter Customer's  Username whose Claim would you like to view");
			 String username=scan.next();
			 try {
				accountNumber=userServiceImpl.getAccountNumber(username);
			} catch (AccountException e1) {
				System.out.println(e1);
				return;
				
			}
			 try {
			 policyNumber=userServiceImpl.userPolicyNumber(accountNumber);
			 }
			 catch(PolicyException e) {
				 System.out.println(e);
			 }
			 int isUserValid=userServiceImpl.getAgentName(username, agentName);
			 if(isUserValid==1) {
				 System.out.println("Customer with username : "+username+" having Account Number : "+accountNumber+" Policy Number : "+policyNumber);
				 isClaimPresent=userServiceImpl.checkForClaim(policyNumber);
				 if(isClaimPresent==1) {
					 userServiceImpl.getClaim(policyNumber);
				 }
				 else {
					 System.out.println("There is no Claim Generated");
				 }
			 }
			 else {
				 System.out.println(username+" is not your customer");
			 }
		}
		else {
			System.out.println("Please Choose Proper option");
		}
	}
//END OF AGENT FUNCTIONALITY
	
	
//Begin of Admin Functionality
	public void adminFunctionality(int choice) {
		if(choice==1) {
			userServiceImpl.getAllClaims();
			 System.out.println("\nPlease Enter PolicyNumber of the Claim on which you want to generate the Report");
			 int policyNumber=scan.nextInt();
			 userServiceImpl.getPolicyDetails(policyNumber);	 
		}
		else if (choice==2) {
			System.out.println("Create User");
			System.out.println("Please Enter  Username");
			String userName=scan.next();
			while(userServiceImpl.checkForUserName(userName)) {
				System.out.println("UserName Exists please Enter unique UserName");
				userName=scan.next();
			};	
			System.out.println("Please Enter  Password");
			String password=scan.next();
			System.out.println("Please choose  UserRole");
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
			if(userrole.equals("Insured")) {
				userServiceImpl.getAgentList();
				System.out.println("Enter an Agent for Insured");
				String agent=scan.next();
				UserRole userRoleObj=new UserRole(userName,password,userrole);
				userServiceImpl.addUserRole(userRoleObj);
				long numOfAccount=101;
				int accountNumber=(int)(numOfAccount+userServiceImpl.getAccountsCount());
				Account accountObj=new Account(accountNumber,userName,agent);
				System.out.println(accountObj);
				userServiceImpl.addAccount(accountObj);
				
			}
			else {
				UserRole userRoleObj=new UserRole(userName,password,userrole);
				userServiceImpl.addUserRole(userRoleObj);
			}
			
			
		}
		else {
			System.out.println("Please Choose Proper Choice");
		}
		
	}
}


