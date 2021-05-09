package com.miniproject.dao;

import java.util.List;

import com.miniproject.entities.Claim;
import com.miniproject.entities.UserRole;

public interface UserRoledao {
	public abstract List<UserRole> getAllUser();
	public abstract List<UserRole> loginUser(String userName,String password,String roleCode);
	public abstract int userPolicyNumber(int accNum);
	public void createClaim(Claim claim);
	public int getAccountNumByUserName(String username);
	public abstract Claim getClaim(int policyNumber) throws Exception;
}
