package com.aman;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
 
public class GetData {
	
	public static void main(String[] args) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		
		Configuration cfg=new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Employee e = null;
		e = (Employee) session.get(Employee.class, 1);
		session.close();
		System.out.println("Size of Address:" + e.getListOfAddress().size());
		System.out.println("Size of Address:" + e.getListOfProject().size());
		
		
		session.close();
		factory.close();
	}
}

