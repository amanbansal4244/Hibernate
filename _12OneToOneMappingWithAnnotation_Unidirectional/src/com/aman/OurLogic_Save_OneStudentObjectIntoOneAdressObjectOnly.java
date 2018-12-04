package com.aman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
 
public class OurLogic_Save_OneStudentObjectIntoOneAdressObjectOnly {

	public static void main(String args[])
	{

		Configuration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession(); 

		Student s=new Student();
		s.setStudentId(22);
		s.setStudentName("java4s");
		s.setGrp("mpc");

		Address ad = new Address();
		ad.setAddressId(2);
		ad.setPlace("Carry");
		ad.setParent(s);  // setting whole 'Student' object

		Transaction tx = session.beginTransaction();

		session.save(ad); // saving only 'Address' object

		tx.commit();

		session.close();
		System.out.println("One to One saving is Done..!!");
		factory.close();

	}
}