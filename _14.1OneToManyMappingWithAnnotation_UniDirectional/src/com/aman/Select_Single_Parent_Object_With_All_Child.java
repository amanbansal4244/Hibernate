package com.aman;
import java.util.Iterator;
import java.util.Set;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class Select_Single_Parent_Object_With_All_Child {

	public static void main(String args[])
	{

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Object o=session.get(Vendor.class, new Integer(101));
		Vendor v=(Vendor)o;
		System.out.println(v.getVendorId());
		System.out.println(v.getVendorName());

		Set<?> s=v.getChildren();
		Iterator<?> it = s.iterator();

		while(it.hasNext())
		{

			Object o1 = it.next();
			Customer c = (Customer) o1;
			System.out.println("---------------------------");
			System.out.println("Customer objects...");
			System.out.println("---------------------------");
			System.out.println(c.getCustomerId());
			System.out.println(c.getCustomerName());
			System.out.println("---------------------------");
		}

		session.close();
		System.out.println("One To Many is Done for selecting.....!");
		factory.close();

	}
}