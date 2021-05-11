package com.miniproject.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
	
	// declaration of instance variables
	@Id
	private int accountNumber;
	private String userName;
	private String agentName;
	
	// default constructor
	public Account() {
	
	// parameterized constructor
	}
	public Account(int accountNumber, String userName, String agentName) {
		this.accountNumber = accountNumber;
		this.userName = userName;
		this.agentName = agentName;
	}
	
	// getters and setters for instance variables
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	// toString() method 
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", userName=" + userName + ", agentName=" + agentName + "]";
	}
}
