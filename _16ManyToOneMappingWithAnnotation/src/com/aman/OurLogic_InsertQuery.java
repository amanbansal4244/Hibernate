package com.aman;
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

		Vendor v =new Vendor();

		v.setVendorId(1001);
		v.setVendorName("java4s6");

		Customer c1=new Customer();

		c1.setCustomerId(50411);
		c1.setCustomerName("customer4");
		c1.setParent(v);

		Customer c2=new Customer();

		c2.setCustomerId(50521);
		c2.setCustomerName("customer5");
		c2.setParent(v);

		Customer c3=new Customer();

		c3.setCustomerId(50631);
		c3.setCustomerName("customer6");
		c3.setParent(v);         		             

		Transaction tx = session.beginTransaction();

		session.save(v);
		session.save(c2);
		session.save(c2);
		session.save(c3);

		tx.commit();
		session.close();
		System.out.println("Many to One with annotation done...!!");
		factory.close();

	}
}