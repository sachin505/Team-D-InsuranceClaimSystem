package com.miniproject.dao;

import java.util.List;

import com.miniproject.entities.Account;
import com.miniproject.entities.Claim;

public interface AgentDao {
	public abstract int userPolicyNumber(int accNum);
	public int getAccountNumByUserName(String agentName);
	public abstract Claim displayClaim(int policyNumber);
	public abstract List<Account> displayAllAccounts(String agentName);
}
