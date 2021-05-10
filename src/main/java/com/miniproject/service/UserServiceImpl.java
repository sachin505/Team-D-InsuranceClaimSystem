package com.miniproject.service;

import java.util.List;

import javax.persistence.NoResultException;

import com.miniproject.dao.UserRoledao;
import com.miniproject.dao.UserRoledaoImpl;
import com.miniproject.entities.Account;
import com.miniproject.entities.Claim;
import com.miniproject.entities.PolicyDetails;
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

	@Override
	public void getClaim(int policyNum) throws NoResultException {
		try {
		Claim claim = userRoledaoImpl.getClaim(policyNum);
		System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n","ClaimNumber","ClaimReason","AccidentLocation","AccidentCity","AccidentState","AccidentZip","ClaimType","PolicyNumber");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-20d%-20s%-20s%-20s%-20s%-20d%-20s%-20d\n",claim.getClaimNumber(),claim.getClaimReason(),claim.getAccidentLocation(),claim.getAccidentCity(),claim.getAccidentState(),claim.getAccidentZip(),claim.getClaimType(),claim.getPolicyNumber());
		}
		 
		catch (Exception e) {
		System.out.println("No Claim Generated for your Policy ");
		}
	}

	@Override
	public int getAgentName(String customerName, String agentName) {
		String agentOfDb=userRoledaoImpl.getAgentName(customerName);
		if(agentName.equals(agentOfDb)) {
			return 1;
		}
		else {
		return 0;
	}
}

	@Override
	public int checkForClaim(int policyNumber) {
		return userRoledaoImpl.checkForClaim(policyNumber);
		 
	}

	@Override
	public void getAllClaims() {
		List<Claim> claimsList=userRoledaoImpl.getAllClaims();
		System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n","ClaimNumber","ClaimReason","AccidentLocation","AccidentCity","AccidentState","AccidentZip","ClaimType","PolicyNumber");
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(Claim claim:claimsList) {
			System.out.printf("%-20d%-20s%-20s%-20s%-20s%-20d%-20s%-20d\n",claim.getClaimNumber(),claim.getClaimReason(),claim.getAccidentLocation(),claim.getAccidentCity(),claim.getAccidentState(),claim.getAccidentZip(),claim.getClaimType(),claim.getPolicyNumber());
		}
	}


	@Override
	public void getCustomersByAgent(String agentName) {
		List<Account> customersList=userRoledaoImpl.getCustomersByAgent(agentName);
		int i=1;
		System.out.println("List of Your Customers ");
		for(Account account:customersList) {
			System.out.println(i+")"+account.getUserName());
			i++;
		}
	}

	@Override
	public void generateClaimReport(int policyNumber) {
		Claim claim=null;
		try {
			 claim=userRoledaoImpl.getClaim(policyNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getPolicyDetails(int policyNumber) {
		List<PolicyDetails> list= userRoledaoImpl.getPolicyDetails(policyNumber);
		for(PolicyDetails policydetails:list) {
			System.out.println(policydetails+" "+policydetails.getPolicyId());
		}
		
	}
	

	

}
