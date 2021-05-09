package com.miniproject.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.miniproject.entities.Policy;
import com.miniproject.exception.PolicyException;

public class PolicyImplemented implements Policydao {
	private EntityManager em=JPAUtil.getEntityManager();

	@Override
	public boolean addPolicy(Policy p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPolicyByNumber(int number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePolicy(int policyNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beignTransaction() {
		em.getTransaction().begin();
		
	}

	@Override
	public void commitTransaction() {
		em.getTransaction().commit();
		
	}

	@Override
	public void viewPolicies() {
		Query query=em.createNamedQuery("getAllPolicise");
		System.out.println(query.getResultList());
	}

	@Override
	public Policy getPolicyByAccNumber(int num) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
