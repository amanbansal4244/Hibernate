
package com.journaldev.jpa.hibernate.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.journaldev.jpa.hibernate.model.Guide;
import com.journaldev.jpa.hibernate.model.Student;

public class HelloWorldClient {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();		
		
        		try {
        	
        			Guide guide1 = new Guide("2000MO10789", "Mike Lawson", 1000);
        			Guide guide2 = new Guide("2000IM10901", "Ian Lamb", 2000);
        	
        			Student student1 = new Student("2014JT50123", "John Smith", guide1);
        			Student student2 = new Student("2014AL50456", "Amy Gill", guide1);
        	
        			guide1.getStudents().add(student1);
        			guide1.getStudents().add(student2);
        	
        			entityManager.persist(guide1);
        			entityManager.persist(guide2);
        	
        			entityManager.getTransaction().commit();
        		}
        		finally {
        				if(entityManager != null) { entityManager.close(); }
        		}
	
	}
}










