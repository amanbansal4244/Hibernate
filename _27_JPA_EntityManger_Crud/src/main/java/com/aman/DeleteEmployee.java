package com.aman;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class DeleteEmployee {

	public static void main( String[ ] args ) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
		EntityManager entitymanager = emf.createEntityManager();
		entitymanager.getTransaction( ).begin( );

		Employee employee = entitymanager.find( Employee.class, 1 );
		entitymanager.remove( employee );
		entitymanager.getTransaction( ).commit( );
		entitymanager.close( );
		emf.close( );
	}
}

