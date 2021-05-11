package com.miniproject.service;

import java.util.List;

import com.miniproject.entities.Account;
import com.miniproject.entities.UserRole;

public interface UserService {
	public abstract int userLogin(String userName, String password, String roleCode);
	public abstract int userPolicyNumber(int accNum);
	public abstract void createClaim(String claimReason, String accidentLocation, String accidentCity, String accidentState,
			int accidentZip, String claimType, int policyNumber);
	public abstract int getAccountNumber(String username);
	public abstract void getClaim(int policyNum);
	public abstract int getAgentName(String customerName, String agentName);
	public abstract int checkForClaim(int policyNumber);
	public abstract void getAllClaims();
	public abstract void getCustomersByAgent(String agentName);
	public abstract void generateClaimReport(int policyNumber);
	public abstract void getPolicyDetails(int policyNumber);
	public abstract void createUser(String username,String password,String roleCode);
	public abstract List getAllUsers();
	public abstract boolean checkForUserName(String userName);
	public abstract void addUserRole(UserRole userRole);
	public abstract void getAgentList();
	public abstract long getAccountsCount();
	public abstract void addAccount(Account account);
	
}
