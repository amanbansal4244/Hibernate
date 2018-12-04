
package com.aman;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HelloWorldClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();
        	
        			Guide guide1 = new Guide("2000MO10789", "Mike Lawson", 1000);
        			Guide guide2 = new Guide("2000IM10901", "Ian Lamb", 2000);
        	
        			Student student1 = new Student("2014JT50123", "John Smith", guide1);
        			Student student2 = new Student("2014AL50456", "Amy Gill", guide1);
        	
        			guide1.getStudents().add(student1);
        			guide1.getStudents().add(student2);
        	
        			session.persist(guide1);
        			session.persist(guide2);
        	
        			txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}










