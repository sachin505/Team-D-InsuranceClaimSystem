package com.miniproject.service;

import java.util.List;

import com.miniproject.dao.UserRoledao;
import com.miniproject.dao.UserRoledaoImpl;
import com.miniproject.entities.Claim;
import com.miniproject.entities.UserRole;

public class UserServiceImpl implements UserService {
	UserRoledao userRoledaoImpl= new UserRoledaoImpl();
	@Override
	public int userLogin(String userName,String password,String roleCode) {
		List<UserRole>list=userRoledaoImpl.loginUser(userName,password,roleCode);
		int flag=0;
		for(UserRole user:list) {
			if(userName.equals(user.getUsername())&&password.equals(user.getPassword())) {
				flag=1;
				break;
			}
			else {
				flag=0;
			}
			
		}
		return flag;
		
	}

	@Override
	public int userPolicyNumber(int accNum) {
		 return userRoledaoImpl.userPolicyNumber(accNum);	 
	}

	
	@Override
	public void createClaim(String claimReason, String accidentLocationStreet, String accidentCity, String accidentState,
			int accidentZip, String claimType, int policyNumber) {
		int claimNumber=(int)(Math.random()*(1500-500+1)+500);
		Claim claimObj=new Claim(claimNumber,claimReason,accidentLocationStreet, accidentCity,accidentState, accidentZip,claimType,policyNumber);
		userRoledaoImpl.createClaim(claimObj);
		System.out.println("claim created ");
		
	}

	@Override
	public int getAccountNumber(String username) {
		return userRoledaoImpl.getAccountNumByUserName(username);	
	}

	

}
