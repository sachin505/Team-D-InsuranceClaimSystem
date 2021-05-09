package com.miniproject.dao;

import com.miniproject.entities.PolicyDetails;

public interface PolicyDetailsdao {
	
	public abstract void addPolicyDetalis(PolicyDetails pd);
	public abstract void beignTransaction();
	public abstract void commitTransaction();
}