package com.aman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
 
public class OurLogic_DeleteQuery {

	public static void main(String args[])
	{

		Configuration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Object o = session.get(Vendor.class, new Integer(100));
		Vendor v = (Vendor)o;

		Transaction tx = session.beginTransaction();
		/****This will be deleting all the parent objects and its corresponding child objects as well.
		 * because we have configured the property cascade="all" ****/
		session.delete(v);  
		tx.commit();

		session.close();
		System.out.println("One To Many is Done for deleting..!!");
		factory.close();

	}
}