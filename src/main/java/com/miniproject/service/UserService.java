package com.miniproject.service;

//importing java packages
import java.util.List;

import com.miniproject.entities.Account;
import com.miniproject.entities.UserRole;
import com.miniproject.exception.AccountException;
import com.miniproject.exception.PolicyException;

// Only Method declarations are done in Interface
public interface UserService {
	
	// Checking for successful UserLogin
	 int userLogin(String userName, String password, String roleCode);
	
	// Getting PolicyNumber based on AccountNumber
	 int userPolicyNumber(int accNum) throws PolicyException;
	
	//Creating the Claim
	 void createClaim(String claimReason, String accidentLocation, String accidentCity, String accidentState,
			int accidentZip, String claimType, int policyNumber);
	
	//Getting AccountNumber based on UserName
	 int getAccountNumber(String username) throws AccountException;
	
	//Getting Claim based on PolicyNumber
	 void getClaim(int policyNum);
	
	// Checking For AgentName equal to the name in Database
	 int getAgentName(String customerName, String agentName);
	
	//Check For Claim based on PolicyNumber Like Claim was exit or not
	 int checkForClaim(int policyNumber);
	
	// Getting all the claims
	 void getAllClaims();
	
	//Getting customerNames based on agentName
	 void getCustomersByAgent(String agentName);
	
	//Generating ClaimReport based on policyNumber
	 void generateClaimReport(int policyNumber);
	
	//Getting PolicyDetails based on policyNumber
	void getPolicyDetails(int policyNumber);
	
	
	// Getting All Users in the form list
	@SuppressWarnings("rawtypes")
	 List getAllUsers();
	
	// Checking For the UserName
	 boolean checkForUserName(String userName);
	
	//Adding User Role to Database
	 void addUserRole(UserRole userRole);
	
	//Getting AgentList
	 void getAgentList();
	
	//Getting Account Count
	 long getAccountsCount();
	
	//Adding Account to Database
	 void addAccount(Account account);
	
}
