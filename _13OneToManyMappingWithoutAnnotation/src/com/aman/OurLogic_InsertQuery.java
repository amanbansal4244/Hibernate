package com.aman;
import java.util.HashSet;
import java.util.Set;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class OurLogic_InsertQuery {
 
public static void main(String args[])
{

	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");

	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	//parent object
	Vendor v =new Vendor();

	v.setVendorId(102);
	v.setVendorName("java4s");

	//creating 3 child objects
	Customer c1=new Customer();
	c1.setCustomerId(555);
	c1.setCustomerName("customer4");

	Customer c2=new Customer();
	c2.setCustomerId(509);
	c2.setCustomerName("customer5");

	Customer c3=new Customer();
	c3.setCustomerId(507);
	c3.setCustomerName("customer6");

	// adding child objects to set, as we taken 3rd property set in parent
	Set<Customer> s=new HashSet<Customer>();
	s.add(c1);
	s.add(c2);
	s.add(c3);

	v.setChildren(s);

	Transaction tx = session.beginTransaction();
	/****This will be saving all the parent objects and its corresponding child objects as well.
	 * because we have configured the property cascade="all" ****/
	session.save(v);

	tx.commit();
	session.close();
	System.out.println("One To Many is Done..!!");
	factory.close();

}
}