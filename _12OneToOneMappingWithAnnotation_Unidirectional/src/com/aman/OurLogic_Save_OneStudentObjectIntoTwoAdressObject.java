package com.aman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
 
public class OurLogic_Save_OneStudentObjectIntoTwoAdressObject {

	public static void main(String args[])
	{

		Configuration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession(); 

		Student s=new Student();
		s.setStudentId(44);
		s.setStudentName("java4s");
		
		Address ad1 = new Address();
		Address ad2 = new Address();
		ad1.setAddressId(55);
		ad2.setPlace("Carry");
		ad2.setParent(s);  // setting whole 'Student' object
		
		ad2.setAddressId(443);
		ad2.setPlace("PUNE");
		ad2.setParent(s);  // setting whole 'Student' object

		Transaction tx = session.beginTransaction();

		session.save(ad1); // saving only 'Address' object
		/****
		 * We try to associate same 'Student' object two or more time two times in 'Address' object,
		 *  we will not get 'org.hibernate.NonUniqueObjectException' because we are using annotation concept.
		 *  and last object  will override the old object values means latest object will be picked.
		 */
		session.save(ad2); // saving only 'Address' object
		
		
		tx.commit();

		session.close();
		System.out.println("One to One saving is Done..!!");
		factory.close();

	}
}