package com.aman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
/****
 * if we delete child, parent will not deleted because, it may have lot of other child objects
 * In many to one relationship, when ever a child object is deleted then its parent object is also deleted, provided
 *  if  that parent object has no other child objects, means 
 * if parent has only one child, in this case if we delete child, parent will also got deleted, 
 * but in all other cases it will throws exception "caused by: java.sql.BatchUpdateException: Cannot delete or update a parent row: a foreign key constraint fails"
 */
public class OurLogic_DeleteQuery {

	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession(); 

		Object o = session.get(Customer.class, new Integer(506));
		Customer c = (Customer)o; 

		Transaction tx = session.beginTransaction();
		session.delete(c);
		tx.commit();

		session.close();
		System.out.println("many to one delete done..!!");
		factory.close();   }
}