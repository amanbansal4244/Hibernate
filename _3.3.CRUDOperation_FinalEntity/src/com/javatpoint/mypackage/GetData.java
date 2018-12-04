package com.javatpoint.mypackage;

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
		SessionFactory factory1=cfg.buildSessionFactory();
		Session session1=factory1.openSession();

		Object obj = session1.load(Employee.class, new Integer(3));
		Employee e = (Employee)obj;
		/****
		 * Note : without Entity as Final : You will not see any select query fired because the load is lazy and it will not load object until you call any method 
		 * other than the getId(), as seen in the difference between the get() vs load() in Hibernate article.
		 * Now, if you make the class final and reprint the name of the class, you will see the actual name of the class as "Customer".
		 *  You will also see the select queries fired by hibernate to initialize the object.
		 */
		System.out.println("Class Name: "+ e.getClass());
		//System.out.println("successfully fetched...." +"First name is:"+ e.getFirstName() + "Last name is: " + e.getLastName() + "id is :" +e.getId());

		session1.close();
		factory1.close();
	}
}

