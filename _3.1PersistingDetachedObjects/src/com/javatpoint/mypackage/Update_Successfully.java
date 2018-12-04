package com.javatpoint.mypackage;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/****
 * When we call update() method on any object, it intern checks, 
 * if that object is already existed in session cache or not — if currently updating object is already there in session cache 
 * then it throws an exception called NonUniqueObjectException, otherwise it will update the object.
 */
public class Update_Successfully {
	public static void main(String... args)

	{
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session1 = factory.openSession();

		Product p=null;          //Transient state..
		Object o=session1.get(Product.class, new Integer(1));
		p=(Product)o;           //now p is in Persistent state..
		session1.close();
		
		p.setPrice("44444");            // p is in Detached state
		
		// re-attaching to session
		Session session2=factory.openSession();
		Transaction tx=session2.beginTransaction();
		
		session2.update(p);      // now p reached to Persistent state
		
		tx.commit();
		session2.close();
		factory.close();
	}}