package com.miniproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.miniproject.entities.Account;
import com.miniproject.entities.Claim;
import com.miniproject.entities.Policy;
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
		Query query=em.createQuery("select userrole from UserRole userrole");
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
			catch(Exception e) {
				System.out.println(e);
			}
		return account.getAccountNumber();
	}
	
}
