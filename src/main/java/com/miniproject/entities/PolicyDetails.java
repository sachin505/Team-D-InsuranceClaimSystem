package com.miniproject.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POLICYDETAILS")
public class PolicyDetails  {
	@Id
	private int policyId;
	private int policyNumber;
	private int questionId;
	private String answer;
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
	
	

}
