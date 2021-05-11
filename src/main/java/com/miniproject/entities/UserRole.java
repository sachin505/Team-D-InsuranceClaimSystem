package com.miniproject.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRole {
	
	// declaration of instance variables
	@Id
	private String username;
	private String password;
	private String rolecode;
	
	// default constructor
	public UserRole() {
		
	}
	
	// parameterized constructor
	public UserRole(String username, String password, String rolecode) {
		this.username = username;
		this.password = password;
		this.rolecode = rolecode;
	}
	
	// getters and setters for instance variables
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRolecode() {
		return rolecode;
	}
	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}
	
	// toString() method
	@Override
	public String toString() {
		return "UserRole [username=" + username + ", password=" + password + ", rolecode=" + rolecode + "]";
	}
}
