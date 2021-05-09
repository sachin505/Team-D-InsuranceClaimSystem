package com.miniproject.service;

import java.util.List;

import com.miniproject.dao.AgentDao;
import com.miniproject.dao.AgentDaoImpl;
import com.miniproject.entities.Account;


public class AgentServiceImpl implements AgentService{
	
	AgentDao agentDaoObj = new AgentDaoImpl();
	@Override
	public void getClaim(int policyNum) {
		
	}
	
	@Override
	public void getAllCustomers(String agentName) {
		List<Account> accountList = agentDaoObj.displayAllAccounts(agentName);
		System.out.println(accountList.size());
		for(Account acc : accountList) {
			System.out.print(acc.getAccountNumber()+" ");
			System.out.print(acc.getUserName()+" ");
			System.out.print(acc.getAgentName()+" ");
			System.out.println();
		}
	}

}