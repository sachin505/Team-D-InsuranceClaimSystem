package com.miniproject.service;

public interface UserService {
	public abstract int userLogin(String userName, String password, String roleCode);
	public abstract int userPolicyNumber(int accNum);
	public abstract void createClaim(String claimReason, String accidentLocation, String accidentCity, String accidentState,
			int accidentZip, String claimType, int policyNumber);
	public abstract int getAccountNumber(String username);
}