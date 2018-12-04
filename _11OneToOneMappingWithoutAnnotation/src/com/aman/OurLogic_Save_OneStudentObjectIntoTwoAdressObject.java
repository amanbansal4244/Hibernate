package com.aman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class OurLogic_Save_OneStudentObjectIntoTwoAdressObject {

	public static void main(String args[])
	{

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession(); 

		Student s=new Student();
		s.setStudentId(44);
		s.setStudentName("java4s");
		
		Address ad1 = new Address();
		Address ad2 = new Address();
		ad1.setAddressId(22);
		ad1.setCity("Carry");
		ad1.setState("NC");
		ad1.setS(s);  // setting whole 'Student' object
		
		ad2.setAddressId(33);
		ad2.setCity("Pune");
		ad2.setState("MH");
		ad2.setS(s);  // setting whole 'Student' object

		Transaction tx = session.beginTransaction();

		session.save(ad1); // saving only 'Address' object
		/****
		 * We try to associate same 'Student' object two or more time two times in 'Address' object,
		 *  we will get 'org.hibernate.NonUniqueObjectException' because one 'Student' object is only for one 'Address' object: 
		 *  reason is 'one to one mapping' means only one object we can associate.
		 *  
		 *  if we comment below line then everything will be fine.
		 */
		//session.save(ad2); // saving only 'Address' object
		
		tx.commit();

		session.close();
		System.out.println("One to One saving is Done..!!");
		factory.close();

	}
}