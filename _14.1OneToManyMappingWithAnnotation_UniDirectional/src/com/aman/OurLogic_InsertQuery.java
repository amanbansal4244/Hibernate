package com.aman;
import java.util.HashSet;
import java.util.Set;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
 
public class OurLogic_InsertQuery {
	public static void main(String[] args)
	{

		Configuration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession(); 

		Vendor v=new Vendor();
		v.setVendorId(1121);
		v.setVendorName("java4s");

		Customer c1=new Customer();
		c1.setCustomerId(500);
		c1.setCustomerName("customer1");

		Customer c2=new Customer();
		c2.setCustomerId(501);
		c2.setCustomerName("customer2");

		Set<Customer> s=new HashSet<Customer>();
		s.add(c1);
		s.add(c2);

		v.setChildren(s);

		Transaction tx=session.beginTransaction();
		/****This will be saving all the parent objects and its corresponding child objects as well.
		 * because we have configured the property cascade="all" ****/
		session.save(v);
		
		tx.commit();

		session.close();
		System.out.println("One to Many Mapping Done...!!!!!!");
		factory.close();
	}
}