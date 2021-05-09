package com.miniproject.dao;

import java.util.List;

import com.miniproject.entities.Policy;
import com.miniproject.exception.PolicyException;



public interface Policydao {
	public abstract boolean addPolicy(Policy p);
	public abstract String getPolicyByNumber(int number);
	public abstract void removePolicy(int policyNumber);
	public abstract void beignTransaction();
	public abstract void commitTransaction();
	public abstract void viewPolicies();
	public abstract Policy getPolicyByAccNumber(int num);
	
	
}
