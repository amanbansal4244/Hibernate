package com.javatpoint.mypackage;

import java.util.Iterator;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
 
public class ListEmployee {
	
	@SuppressWarnings("unused")
	public void listEmployee() {

		//creating configuration object
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

		//creating session factory object
		SessionFactory factory=cfg.buildSessionFactory();

		//creating session object
		Session session=factory.openSession();

		//creating transaction object
		Transaction tx= null;
		try {
			tx = session.beginTransaction();

			List employees = session.createQuery("FROM Employee").list();
			
			for(Iterator iterator = employees.iterator();iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.println("First Name:" + employee.getFirstName());
				System.out.println("Last Name:" + employee.getLastName());
				System.out.println("Salary:" + employee.getSalary());
			}
			tx.commit();
		}catch(HibernateException e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}

	}
}

