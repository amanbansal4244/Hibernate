package com.aman;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class ListEmployee {
	
	@SuppressWarnings("unused")
	public void listEmployee() {

		/****
		 * In Hibernate 3.6, “org.hibernate.cfg.AnnotationConfiguration” is deprecated, 
		 * and all its functionality has been moved to “org.hibernate.cfg.Configuration“.
		 * So , you can safely replace your “AnnotationConfiguration” with “Configuration” class.
		 */
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx= session.beginTransaction();
		Query query1 = session.createQuery("from Employee where id =4");
		/**** Here I am telling to hibernate that make this query as Cacheable and put the result of 
		 * this query in 'Query Cache Region' so that i can access same result subsequently.
		 * we need to set 'setCacheable'  to all queries object because, it not just add the data into 'Query Cache Region', 
		 * it also tell to hibernate that, you need to look into 'Query Cache Region' as well.
		 * 
		 * So in this first place,  'setCacheable' will look into 'Query Cache Region', if data is not present then add 
		 * the data into 'Query Cache Region'
		 */
		query1.setCacheable(true);
		query1.list();
		Session session1=factory.openSession();
		Transaction tx1= session1.beginTransaction();
		Query query2 = session1.createQuery("from Employee where id =4");
		/**** 
		 * In this case, 'setCacheable' will look into 'Query Cache Region' and pull up the data since
		 * data is already present in 'Query Cache Region'.
		 */
		query1.setCacheable(true);
		query2.list();
		tx1.commit();
		session1.close();

	}
	
	public static void main(String[] args) {
		new ListEmployee().listEmployee();
	}
}

