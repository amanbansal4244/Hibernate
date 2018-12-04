package com.aman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class OurLogic_Save_TwoStudentObjectIntoTwoAdressObject {

	public static void main(String args[])
	{

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession(); 

		Student s=new Student();
		s.setStudentId(22);
		s.setStudentName("java4s");
		
		Student s1=new Student();
		s1.setStudentId(34);
		s1.setStudentName("java");
		
		Address ad1 = new Address();
		Address ad2 = new Address();
		ad1.setAddressId(509);
		ad1.setCity("Carry");
		ad1.setState("NC");
		ad1.setS(s);  // setting whole 'Student' object
		
		ad2.setAddressId(409);
		ad2.setCity("Pune");
		ad2.setState("MH");
		ad2.setS(s1);  // setting whole 'Student' object

		Transaction tx = session.beginTransaction();

		session.save(ad1); // saving only 'Address' object
		session.save(ad2); // saving only 'Address' object
		
		tx.commit();

		session.close();
		System.out.println("One to One saving is Done..!!");
		factory.close();

	}
}