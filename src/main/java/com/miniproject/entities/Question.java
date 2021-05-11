package com.miniproject.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Question {
	
	// declaration of instance variables
	@Id
	private int questionId;
	private String question;
	
	// default constructor
	public Question() {
		
	}
	
	// parameterized constructor
	public Question(int questionId, String question) {
		this.questionId = questionId;
		this.question = question;
	}
	
	// getters and setters for instance variables
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	// toString() method
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + "]";
	}
}
