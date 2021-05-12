package com.miniproject.service;

import java.util.List;
import javax.persistence.NoResultException;
import com.miniproject.dao.UserRoledao;
import com.miniproject.dao.UserRoledaoImpl;
import com.miniproject.entities.Account;
import com.miniproject.entities.Claim;
import com.miniproject.entities.PolicyDetails;
import com.miniproject.entities.Question;
import com.miniproject.entities.UserRole;
import com.miniproject.exception.AccountException;
import com.miniproject.exception.PolicyException;

//Implementations of method declared in UserService Interface
public class UserServiceImpl implements UserService {
	
	//Creating a reference variable for Interface 
	UserRoledao userRoledaoImpl= new UserRoledaoImpl();
		
	// Checking for successful UserLogin
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

	//// Getting PolicyNumber based on AccountNumber
	@Override
	public int userPolicyNumber(int accNum) throws PolicyException {
		if(accNum==0) {
			System.out.println("No account found!");
			return 0;
		}
		else {
			return userRoledaoImpl.userPolicyNumber(accNum);
		}
	}

	////Creating the Claim
	@Override
	public void createClaim(String claimReason, String accidentLocationStreet, String accidentCity, String accidentState,
		int accidentZip, String claimType, int policyNumber) {
		int claimNumber=(int)(Math.random()*(1500-500+1)+500);
		Claim claimObj=new Claim(claimNumber,claimReason,accidentLocationStreet, accidentCity,accidentState, accidentZip,claimType,policyNumber);
		userRoledaoImpl.createClaim(claimObj);
		System.out.println("claim created ");
	}

	////Getting AccountNumber based on UserName
	@Override
	public int getAccountNumber(String username) throws AccountException{
		int accountNumber=0;
		accountNumber=userRoledaoImpl.getAccountNumByUserName(username);
		return accountNumber;
	}

	////Getting Claim based on PolicyNumber
	@Override
	public void getClaim(int policyNum) throws NoResultException {
		try {
		Claim claim = userRoledaoImpl.getClaim(policyNum);
			if(claim!=null) {
				System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n","ClaimNumber","ClaimReason","AccidentLocation","AccidentCity","AccidentState","AccidentZip","ClaimType","PolicyNumber");
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-20d%-20s%-20s%-20s%-20s%-20d%-20s%-20d\n",claim.getClaimNumber(),claim.getClaimReason(),claim.getAccidentLocation(),claim.getAccidentCity(),claim.getAccidentState(),claim.getAccidentZip(),claim.getClaimType(),claim.getPolicyNumber());
			}
		} 
		catch (Exception e) {
		System.out.println("No Claim Generated for your Policy ");
		}
	}

	// Checking For AgentName equal to the name in Database
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

	//Check For Claim based on PolicyNumber Like Claim was exit or not
	@Override
	public int checkForClaim(int policyNumber) {
		return userRoledaoImpl.checkForClaim(policyNumber);
		 
	}

	// Getting all the claims
	@Override
	public void getAllClaims() {
		List<Claim> claimsList=userRoledaoImpl.getAllClaims();
		System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n","ClaimNumber","ClaimReason","AccidentLocation","AccidentCity","AccidentState","AccidentZip","ClaimType","PolicyNumber");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(Claim claim:claimsList) {
			System.out.printf("%-20d%-20s%-20s%-20s%-20s%-20d%-20s%-20d\n",claim.getClaimNumber(),claim.getClaimReason(),claim.getAccidentLocation(),claim.getAccidentCity(),claim.getAccidentState(),claim.getAccidentZip(),claim.getClaimType(),claim.getPolicyNumber());
		}
	}

	//Getting customerNames based on agentName
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

	//Generating ClaimReport based on policyNumber
	@Override
	public void generateClaimReport(int policyNumber) {
		@SuppressWarnings("unused")
		Claim claim=null;
		try {
			 claim=userRoledaoImpl.getClaim(policyNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Getting PolicyDetails based on policyNumber
	@Override
	public void getPolicyDetails(int policyNumber) {
		int isClaimPresent=userRoledaoImpl.checkForClaim(policyNumber);
		if(isClaimPresent==1) {
		System.out.println("This is Claim Report\n ");
		getClaim(policyNumber);
		System.out.println();
		List<PolicyDetails> list= userRoledaoImpl.getPolicyDetails(policyNumber);
			for(PolicyDetails policydetails:list) {
				Question question=userRoledaoImpl.getQuestionByQId(policydetails.getQuestionId());
				System.out.println(question.getQuestion()+"    "+policydetails.getAnswer());	
			}
		}
		else {
			System.out.println("There is no Claim with this policy number "+policyNumber);
		}
	}

	
	// Getting All Users in the form list
	@SuppressWarnings("rawtypes")
	@Override
	public List getAllUsers() {
		return userRoledaoImpl.getAllUser();
	}

	// Checking For the UserName
	@Override
	public boolean checkForUserName(String userName) {
		@SuppressWarnings("rawtypes")
		List usersList=getAllUsers();
		return usersList.contains(userName);
		
	}

	//Adding User Role to Database
	@Override
	public void addUserRole(UserRole userRole) {
		userRoledaoImpl.addUserRole(userRole);
		System.out.println("user added successfully");
		
	}

	//Getting AgentList
	@Override
	public void getAgentList() {
		@SuppressWarnings("unchecked")
		List<String> agentsList=userRoledaoImpl.getAllAgents();
		int i=1;
		System.out.println("List of agents");
		System.out.println("______________________________________");
		for(String agent:agentsList) {
			System.out.println(i+")"+agent);
			i++;
		}
		
	}

	//Getting Account Count
	@Override
	public long getAccountsCount() {
		return userRoledaoImpl.getAccountsCount();
		
	}

	//Adding Account to Database
	@Override
	public void addAccount(Account account) {
		userRoledaoImpl.addAccount(account);
		System.out.println("Account generated");
	}
	
}
