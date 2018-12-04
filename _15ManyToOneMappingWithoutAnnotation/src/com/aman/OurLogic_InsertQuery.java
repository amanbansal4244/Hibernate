package com.aman;
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

		Vendor_Parent_Pojo v =new Vendor_Parent_Pojo();

		v.setVendorId(101);
		v.setVendorName("java4s");

		Customer_Child_Pojo c1=new Customer_Child_Pojo();

		c1.setCustomerId(504);
		c1.setCustomerName("customer4");
		c1.setParentObjects(v);

		Customer_Child_Pojo c2=new Customer_Child_Pojo();

		c2.setCustomerId(505);
		c2.setCustomerName("customer5");
		c2.setParentObjects(v);

		Customer_Child_Pojo c3=new Customer_Child_Pojo();

		c3.setCustomerId(506);
		c3.setCustomerName("customer6");
		c3.setParentObjects(v);           		             

		Transaction tx = session.beginTransaction();

		/****In many to one mapping , we are saving children object not parent object. 
		 * children object will save parent object automatically.
		 */
		session.save(c1);
		session.save(c2);
		session.save(c3);

		tx.commit();
		session.close();
		System.out.println("Many To One is Done..!!");
		factory.close();

	}
}