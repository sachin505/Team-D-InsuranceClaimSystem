package com.miniproject.dao;

import java.util.List;

import com.miniproject.entities.Account;
import com.miniproject.entities.Claim;
import com.miniproject.entities.PolicyDetails;
import com.miniproject.entities.Question;
import com.miniproject.entities.UserRole;

public interface UserRoledao {
	public abstract List<UserRole> getAllUser();
	public abstract List<UserRole> loginUser(String userName,String password,String roleCode);
	public abstract int userPolicyNumber(int accNum);
	public void createClaim(Claim claim);
	public int getAccountNumByUserName(String username);
	public abstract Claim getClaim(int policyNumber) ;
	public abstract String getAgentName(String customerName);
	public abstract int  checkForClaim(int policyNumber);
	public abstract List<Claim> getAllClaims();
	public abstract List<Account> getCustomersByAgent(String agentName);
	public abstract List<PolicyDetails> getPolicyDetails(int policyNumber);
	public abstract Question getQuestionByQId(int questionId);
	public abstract void addUserRole(UserRole userRole);
	public abstract List getAllAgents();
	public abstract long getAccountsCount();
	public abstract void addAccount(Account account);
}
