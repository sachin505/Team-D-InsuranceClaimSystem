package com.miniproject.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POLICYDETAILS")
public class PolicyDetails  {
	
	// declaration of instance variables
	@Id
	private int policyId;
	private int policyNumber;
	private int questionId;
	private String answer;
	
	// default constructor
	public PolicyDetails() {
		
	}
	// parameterized constructor
	public PolicyDetails(int policyId, int policyNumber, int questionId, String answer) {
		this.policyId = policyId;
		this.policyNumber = policyNumber;
		this.questionId = questionId;
		this.answer = answer;
	}
	
	// getters and setters for instance variables
	public int getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int i) {
		this.questionId = i;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	// toString() method
	@Override
	public String toString() {
		return "PolicyDetails [policyId=" + policyId + ", policyNumber=" + policyNumber + ", questionId=" + questionId
				+ ", answer=" + answer + "]";
	}

}
