package com.aman;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class ListEmployee {
	
	@SuppressWarnings("unused")
	public void listEmployee() {

		/****
		 * In Hibernate 3.6, “org.hibernate.cfg.AnnotationConfiguration” is deprecated, 
		 * and all its functionality has been moved to “org.hibernate.cfg.Configuration“.
		 * So , you can safely replace your “AnnotationConfiguration” with “Configuration” class.
		 */
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx= session.beginTransaction();
		Object obj = session.get(Employee.class,new Integer(4));
		
		Session session1=factory.openSession();
		Transaction tx1= session1.beginTransaction();
		Object obj1 = session1.get(Employee.class, new Integer(4));
		tx1.commit();
		session1.close();

	}
	
	public static void main(String[] args) {
		new ListEmployee().listEmployee();
	}
}

