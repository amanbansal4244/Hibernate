package com.javatpoint.mypackage;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/****
 * Like update() method merge is also used to transfer an object from detached stated to persistent state.
 * If we call merge() method, then it verifies whether the same object has existed in the session cache or not. 
 * If the object has existed in the cache then the current changes are copied in to the cache, otherwise, it will load the values to cache.
 */
public class Merge_Successfully {
	public static void main(String... args)

	{
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session1 = factory.openSession();

		Product p=null;          //Transient state..
		p =(Product)session1.get(Product.class, new Integer(1)); //now p is in Persistent state..
		session1.close();
		
		p.setPrice("44332");            // p is in Detached state
		
		Session session2=factory.openSession();
		Product p2=(Product)session2.get(Product.class, new Integer(1));
		Transaction tx=session2.beginTransaction();
		/****
		 * When we call update() method, if the object already existed in cache update() method will 
		 * throw exception whereas merge() method copies the changes in to cache.
		 */
		session2.merge(p);      // now p reached to Persistent state
		
		tx.commit();
		session2.close();
		factory.close();
	}}