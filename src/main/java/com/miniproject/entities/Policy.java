package com.miniproject.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name="Policy")
public class Policy {
	@Id
	private int policyNumber;
	private String policyPremium;
	private int accountNumber;

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
	@Override
	public String toString() {
		return "Policy [policyNumber=" + policyNumber + ", policyPermium=" + policyPremium + ", accountnumber="
				+ accountNumber + "]";
	}
	

}
