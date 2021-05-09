package com.miniproject.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	static {
		emf=Persistence.createEntityManagerFactory("JPA-PU");	
	}
	public static EntityManager getEntityManager() {
		em=emf.createEntityManager();
		return em;
	}
	public static void closeEntityManager(){
		emf.close();
		em.close();
	}
}
