package com.miniproject.service;

public interface AgentService {
	
	public abstract void getClaim(int policyNum);
	
	public abstract void getAllCustomers(String agentName);
}
