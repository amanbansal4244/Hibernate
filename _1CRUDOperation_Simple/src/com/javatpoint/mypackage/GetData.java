package com.javatpoint.mypackage;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
 
public class GetData {
	
	public static void main(String[] args) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		
		//creating configuration object
		Configuration cfg1=new Configuration();
		cfg1.configure("hibernate.cfg.xml");//populates the data of the configuration file
		
		//creating session factory object
		SessionFactory factory1=cfg1.buildSessionFactory();
		
		//creating session object
		Session session1=factory1.openSession();
		
		Object obj = session1.load(Employee.class, new Integer(93));
		Employee e = (Employee)obj;
		
		System.out.println("successfully fetched...." +"First name is:"+ e.getFirstName() + "Last name is: " + e.getLastName() + "id is :" +e.getId());
		
		session1.close();
		factory1.close();
	}
}

