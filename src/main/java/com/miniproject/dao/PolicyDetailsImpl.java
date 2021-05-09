package com.miniproject.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.miniproject.entities.PolicyDetails;

public class PolicyDetailsImpl implements PolicyDetailsdao{
	private EntityManager em=JPAUtil.getEntityManager();
	@Override
	public void addPolicyDetalis(PolicyDetails pd) {
	em.persist(pd);
	}
	@Override
	public void beignTransaction() {
		em.getTransaction().begin();
	}
	@Override
	public void commitTransaction() {
		em.getTransaction().commit();
		
	}
	
	
	
	

}
