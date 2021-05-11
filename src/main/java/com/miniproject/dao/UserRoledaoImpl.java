package com.miniproject.dao;

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

public class UserRoledaoImpl implements UserRoledao{
	EntityManager em;
	public UserRoledaoImpl() {
	em=JPAUtil.getEntityManager();
	}
	@Override
	public List<UserRole> getAllUser() {
		List <UserRole> list=null;
		try {
		Query query=em.createQuery("select username from UserRole userrole");
		list=query.getResultList();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	@Override
	public List<UserRole> loginUser(String userName,String password,String roleCode) {
		List<UserRole> users=null;
		try {
			Query query=em.createQuery("select userrole from UserRole userrole where userrole.rolecode=:role");
			query.setParameter("role",roleCode);
			
			users=query.getResultList();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		return users;
	}
	@Override
	public int userPolicyNumber(int accNum) {
		Policy policyNumber=null;
		try {
			Query query=em.createQuery("select policy from Policy policy where policy.accountNumber=:accountnumber");
			query.setParameter("accountnumber",accNum);
			policyNumber=(Policy) query.getSingleResult();
		}
		catch(Exception e) {
				System.out.println("There is no Policy for this user");
			}	
		return policyNumber.getPolicyNumber();
	}
	@Override
	public void createClaim(Claim claim) {
		em.getTransaction().begin();
		em.persist(claim);
		em.getTransaction().commit();
	}
	@Override
	public int getAccountNumByUserName(String username) {
	 Account account=null;
		try {
			Query query=em.createQuery("select account from Account account where account.userName=:usn");
			query.setParameter("usn",username);
			account=(Account)query.getSingleResult();
			}
//			catch(NoResultException e) {
//				System.out.println("");
//			}
			catch(Exception e) {
				System.out.println(e);
			}
		if(account!=null) { 
			return account.getAccountNumber();
		}
		else {
			return 0;
		}
	}
	@Override
	public Claim getClaim(int policyNumber){
		Claim claim = null;
		try {
			Query query = em.createQuery("select claim from Claim claim where claim.policyNumber = :pnum");
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
	@Override
	public String getAgentName(String customerName) {
		 Account account=null;
			try {
				Query query=em.createQuery("select account from Account account where account.userName=:usn");
				query.setParameter("usn",customerName);
				account=(Account)query.getSingleResult();
				}
			catch(NoResultException | NullPointerException e) {
				System.out.println(customerName+" is not your customer.");
			}
//				catch(Exception e) {
//					System.out.println(e);
//				}
			if(account!=null) {
				return account.getAgentName();
			}
			else {
				return " ";
			}
	}
	@Override
	public int checkForClaim(int policyNumber) {
		Claim claim = null;
		int isPresent=0;
		try {
			Query query = em.createQuery("select claim from Claim claim where claim.policyNumber = :pnum");
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
	@Override
	public List<Claim> getAllClaims() {
		List<Claim> claimsList=null;
		Query query=em.createQuery("select claim from Claim claim");
		claimsList=query.getResultList();
		return claimsList;
	}
	@Override
	public List<Account> getCustomersByAgent(String agentName) {
		List<Account> customersList=null;
		try {
			Query query = em.createQuery("select account from Account account where account.agentName = :agentName");
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
	@Override
	public List<PolicyDetails> getPolicyDetails(int policyNumber) {
		List<PolicyDetails> policyDetails=null;
		try {
			Query query = em.createQuery("select policydetails from PolicyDetails policydetails where policydetails.policyNumber = :policyNumber");
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
	@Override
	public Question getQuestionByQId(int questionId) {
		Question question=null;
		try {
			Query query = em.createQuery("select question from Question question where question.questionId = :questionId");
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
	@Override
	public void addUserRole(UserRole userRole) {
		em.getTransaction().begin();
		em.persist(userRole);
		em.getTransaction().commit();
	}
	@Override
	public List getAllAgents() {
		List AgentList=null;
		try {
			Query query = em.createQuery("select distinct agentName from Account account");
			
			AgentList=query.getResultList();
		}
		catch(NoResultException e) {
		System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return AgentList;
	}
	@Override
	public long getAccountsCount() {
		long accCount=0;
		try {
			Query query = em.createQuery("select count(accountNumber) from Account account");
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
	@Override
	public void addAccount(Account account) {
		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
	}
	
}
