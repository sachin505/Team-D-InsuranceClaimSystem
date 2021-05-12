package com.miniproject.dao;

// importing java packages
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import com.miniproject.entities.Account;
import com.miniproject.entities.Claim;
import com.miniproject.entities.Policy;
import com.miniproject.entities.PolicyDetails;
import com.miniproject.entities.Question;
import com.miniproject.entities.UserRole;
import com.miniproject.exception.AccountException;
import com.miniproject.exception.PolicyException;

// implementations of methods declared in UserRoledao.java interface
public class UserRoledaoImpl implements UserRoledao {

	// creating object for EntityManager class
	EntityManager entityManager;

	// default constructor
	public UserRoledaoImpl() {
		entityManager=JPAUtility.getEntityManager();
	}

	// getting all users from table User_Role in the form of list
	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getAllUser() {
		List <UserRole> list=null;
		try {
			Query query=entityManager.createQuery("select username from UserRole userrole");
			list=query.getResultList();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}

	// getting list of User_Role for login 
	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> loginUser(String userName,String password,String roleCode) {
		List<UserRole> users=null;
		try {
			Query query=entityManager.createQuery("select userrole from UserRole userrole where userrole.rolecode=:role");
			query.setParameter("role",roleCode);
			users=query.getResultList();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return users;
	}

	// getting policy number based on account number
	@Override
	public int userPolicyNumber(int accNum) throws PolicyException{
		Policy policyNumber=null;
		try {
			Query query=entityManager.createQuery("select policy from Policy policy where policy.accountNumber=:accountnumber");
			query.setParameter("accountnumber",accNum);
			policyNumber=(Policy) query.getSingleResult();
		}
		catch(NullPointerException |NoResultException exception) {
			throw new PolicyException("No Policy Created");
		}	
		return policyNumber.getPolicyNumber();
	}

	// creating claim
	@Override
	public void createClaim(Claim claim) {
		entityManager.getTransaction().begin();
		entityManager.persist(claim);
		entityManager.getTransaction().commit();
	}

	// getting account number based on user name
	@Override
	public int getAccountNumByUserName(String username) throws AccountException {
		Account account=null;
		try {
			Query query=entityManager.createQuery("select account from Account account where account.userName=:usn");
			query.setParameter("usn",username);
			account=(Account)query.getSingleResult();
		}
		catch(NullPointerException | NoResultException e) {
			throw new AccountException("NO Account Found");
		}
		
		return account.getAccountNumber();
	}

	// getting claim based on policy number
	@Override
	public Claim getClaim(int policyNumber){
		Claim claim = null;
		try {
			Query query = entityManager.createQuery("select claim from Claim claim where claim.policyNumber = :pnum");
			query.setParameter("pnum", policyNumber);
			claim = (Claim) query.getSingleResult();
		}
		catch(NoResultException e) {
			System.out.println("Choose a valid policy Number");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return claim;
	}

	// getting agent name based on customer name
	@Override
	public String getAgentName(String customerName) {
		Account account=null;
		try {
			Query query=entityManager.createQuery("select account from Account account where account.userName=:usn");
			query.setParameter("usn",customerName);
			account=(Account)query.getSingleResult();
		}
		catch(NoResultException | NullPointerException e) {
			System.out.println(customerName+" is not your customer.");
		}
		if(account!=null) {
			return account.getAgentName();
		}
		else {
			return " ";
		}
	}

	// checking claim based on policy number
	@Override
	public int checkForClaim(int policyNumber) {
		Claim claim = null;
		int isPresent=0;
		try {
			Query query = entityManager.createQuery("select claim from Claim claim where claim.policyNumber = :pnum");
			query.setParameter("pnum", policyNumber);
			claim = (Claim) query.getSingleResult();
			isPresent=1;
		}
		catch(NoResultException e) {
			isPresent=0;
		}
		catch(Exception e) {
			isPresent=0;
		}
		return isPresent;
	}

	// getting list of all claims
	@SuppressWarnings("unchecked")
	@Override
	public List<Claim> getAllClaims() {
		List<Claim> claimsList=null;
		Query query=entityManager.createQuery("select claim from Claim claim");
		claimsList=query.getResultList();
		return claimsList;
	}

	// getting all customers based on agent name in list form
	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getCustomersByAgent(String agentName) {
		List<Account> customersList=null;
		try {
			Query query = entityManager.createQuery("select account from Account account where account.agentName = :agentName");
			query.setParameter("agentName", agentName);
			customersList =query.getResultList();
		}
		catch(NoResultException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return customersList;
	}

	// getting policy details based on policy number in list form
	@SuppressWarnings("unchecked")
	@Override
	public List<PolicyDetails> getPolicyDetails(int policyNumber) {
		List<PolicyDetails> policyDetails=null;
		try {
			Query query = entityManager.createQuery("select policydetails from PolicyDetails policydetails where policydetails.policyNumber = :policyNumber");
			query.setParameter("policyNumber",policyNumber);
			policyDetails =query.getResultList();
		}
		catch(NoResultException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return policyDetails;
	}

	// getting question based on questionId
	@Override
	public Question getQuestionByQId(int questionId) {
		Question question=null;
		try {
			Query query = entityManager.createQuery("select question from Question question where question.questionId = :questionId");
			query.setParameter("questionId",questionId);
			question=(Question) query.getSingleResult();
		}
		catch(NoResultException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}

		return question;
	}

	// adding new user role
	@Override
	public void addUserRole(UserRole userRole) {
		entityManager.getTransaction().begin();
		entityManager.persist(userRole);
		entityManager.getTransaction().commit();
	}

	// getting list of all agents
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllAgents() {
		List<String> agentList=null;
		try {
			Query query = entityManager.createQuery("select distinct agentName from Account account");
			agentList=query.getResultList();
		}
		catch(NoResultException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return agentList;
	}

	// getting count on account
	@Override
	public long getAccountsCount() {
		long accCount=0;
		try {
			Query query = entityManager.createQuery("select count(accountNumber) from Account account");
			accCount=(long) query.getSingleResult();
		}
		catch(NoResultException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return accCount;
	}

	// adding new account
	@Override
	public void addAccount(Account account) {
		entityManager.getTransaction().begin();
		entityManager.persist(account);
		entityManager.getTransaction().commit();
	}

}
