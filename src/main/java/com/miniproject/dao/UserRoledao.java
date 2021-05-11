package com.miniproject.dao;

// importing java packages
import java.util.List;
import com.miniproject.entities.Account;
import com.miniproject.entities.Claim;
import com.miniproject.entities.PolicyDetails;
import com.miniproject.entities.Question;
import com.miniproject.entities.UserRole;

// only method declarations are done in interface
public interface UserRoledao {

	public List<UserRole> getAllUser(); // getting all users from table User_Role in the form of list


	public List<UserRole> loginUser(String userName,String password,String roleCode); 	// getting list of User_Role for login 


	public int userPolicyNumber(int accNum); // getting policy number based on account number


	public void createClaim(Claim claim); // creating claim


	public int getAccountNumByUserName(String username); // getting account number based on user name


	public Claim getClaim(int policyNumber) ; // getting claim based on policy number


	public String getAgentName(String customerName); // getting agent name based on customer name


	public int  checkForClaim(int policyNumber); // checking claim based on policy number


	public List<Claim> getAllClaims(); // getting list of all claims


	public List<Account> getCustomersByAgent(String agentName); // getting all customers based on agent name in list form


	public List<PolicyDetails> getPolicyDetails(int policyNumber); // getting policy details based on policy number in list form


	public Question getQuestionByQId(int questionId); // getting question based on questionId


	public void addUserRole(UserRole userRole); // adding new user role


	public List getAllAgents(); // getting list of all agents


	public long getAccountsCount(); // getting count on account


	public void addAccount(Account account); // adding new account
}
