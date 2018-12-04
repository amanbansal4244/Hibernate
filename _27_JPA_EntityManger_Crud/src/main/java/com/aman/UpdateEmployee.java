package com.aman;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class UpdateEmployee {

	public static void main( String[ ] args ) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeService");
		EntityManager entitymanager = emfactory.createEntityManager();

		entitymanager.getTransaction().begin();
		Employee employee = entitymanager.find( Employee.class, 1 );

		//before update
		System.out.println( employee );
		employee.setSalary( 46000 );
		entitymanager.getTransaction( ).commit( );

		//after update
		System.out.println( employee );
		entitymanager.close();
		emfactory.close();
	}
}

