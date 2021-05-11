package com.miniproject.dao;

// importing java packages
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtility {
	
	// declaring instance variables
	private static EntityManagerFactory emf;
	private static EntityManager entityManager;
	
	// initializing EntityManager object
	static {
		emf=Persistence.createEntityManagerFactory("JPA-PU");	
	}
	
	// initializing EntityManagerFactory object
	public static EntityManager getEntityManager() {
		entityManager=emf.createEntityManager();
		return entityManager;
	}
	
	// closing the objects
	public static void closeEntityManager(){
		emf.close();
		entityManager.close();
	}
}
