package com.miniproject.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Policy")
public class Policy {
	
	// declaration of instance variables
	@Id
	private int policyNumber;
	private String policyPremium;
	private int accountNumber;
	
	// default constructor
	public Policy() {
		
	}
	
	// parameterized constructor
	public Policy(int policyNumber, String policyPremium, int accountNumber) {
		this.policyNumber = policyNumber;
		this.policyPremium = policyPremium;
		this.accountNumber = accountNumber;
	}
	
	// getters and setters for instance variables
	public int getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getPolicyPermium() {
		return policyPremium;
	}
	
	public void setPolicyPermium(String policyPermium) {
		this.policyPremium = policyPermium;
	}
	public int getAccountnumber() {
		return accountNumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountNumber = accountnumber;
	}
	
	// toString() method
	@Override
	public String toString() {
		return "Policy [policyNumber=" + policyNumber + ", policyPermium=" + policyPremium + ", accountnumber="
				+ accountNumber + "]";
	}
	
}
