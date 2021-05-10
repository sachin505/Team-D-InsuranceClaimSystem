package com.miniproject.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.miniproject.entities.Account;
import com.miniproject.entities.Claim;
import com.miniproject.entities.Policy;

public class AgentDaoImpl implements AgentDao {

	EntityManager em;
	@Override
	public int userPolicyNumber(int accNum) {
		Policy policynumber=null;
		try {
			Query query=em.createQuery("select policy from Policy policy where policy.accountnumber=:accountnumber");
			query.setParameter("accountnumber",accNum);
			 policynumber= (Policy) query.getSingleResult();
			}
			catch(Exception e) {
				System.out.println(e);
			}	
		return policynumber.getPolicyNumber();
	}
	@Override
	public int getAccountNumByUserName(String agentName) {
		Account account=null;
		try {
			Query query=em.createQuery("select account from Account account where account.agentName=:agentName");
			query.setParameter("agentName",agentName);
			account=(Account)query.getSingleResult();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		return account.getAccountNumber();
	}
	@Override
	public Claim displayClaim(int policyNumber) {
		
		return null;
	}
	@Override
	public List<Account> displayAllAccounts(String agentName) {
		List<Account> accountList = null;
		try {
			System.out.println("in try "+agentName);
			Query query = em.createQuery("select account from Account account where account.agentName = :name");
			System.out.println("in try "+agentName);
			query.setParameter("name", agentName);
			accountList = query.getResultList();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return accountList;
	}
	

}
