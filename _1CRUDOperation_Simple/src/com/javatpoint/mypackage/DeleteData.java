package com.javatpoint.mypackage;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
 
public class DeleteData {
	
	public static void main(String[] args) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		
		//creating configuration object
		Configuration cfg1=new Configuration();
		cfg1.configure("hibernate.cfg.xml");//populates the data of the configuration file
		//creating session factory object
		SessionFactory factory=cfg1.buildSessionFactory();
		//creating session object
		Session session=factory.openSession();
		
		Object obj = session.load(Employee.class, new Integer(94));
		Employee e = (Employee)obj;
		
		//creating transaction object
		Transaction t=session.beginTransaction();
			
			session.delete(e);
			
		t.commit();//transaction is committed.
		System.out.println("successfully deleted.");
		session.close();
		factory.close();
		
	}
}

