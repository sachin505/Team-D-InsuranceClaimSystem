package com.miniproject.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Question {
@Id
private int questionId;
private String question;
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
@Override
public String toString() {
	return "Question [questionId=" + questionId + ", question=" + question + "]";
}
}
