package com.miniproject.pl;

import java.util.List;

import com.miniproject.dao.JPAUtil;
import com.miniproject.dao.UserRoledaoImpl;
import com.miniproject.dao.UserRoledao;
import com.miniproject.entities.Policy;
import com.miniproject.entities.PolicyDetails;
import com.miniproject.entities.UserRole;
import com.miniproject.exception.PolicyDetailsException;
import com.miniproject.exception.PolicyException;
import com.miniproject.service.UserInterFace;

public class Client {

	public static void main(String[] args){
//		UserRoledao user=new UserRoledaoImpl();
//		List<UserRole> list=user.getAllUser();
//		for(UserRole users:list) {
//			if(users.getRolecode().equals("Insured")){
//			System.out.println(users.getUsername());
//			}
//		}
		
		UserInterFace ui=new UserInterFace();
		ui.welcomeMessage();
		ui.loginUser();
		
	}

}
