
package com.aman;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SavingOperation {
	public static void main(String[] args) {
		
			Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();
        	
        			//Adding data to guide and student table by adding a Guide and associating a Student with it
        			Guide guide1 = new Guide("2000MO10789", "Mike Lawson", 1000);
        			Guide guide2 = new Guide("2000IM10901", "Ian Lamb", 2000);
        	
        			Guide guide3 = new Guide("2000DO10777", "David Crow", 3000);		
        			
        			Student student1 = new Student("2014JT50123", "John Smith", guide2);
        			Student student2 = new Student("2014AL50456", "Amy Gill", guide2);
        			Student student3 = new Student("2014BE50789", "Bruce Lee");
        			Student student4 = new Student("2014RG50347", "Rahul Singh",guide3);
        			
        	
        			guide1.getStudents().add(student1);
        			guide1.getStudents().add(student2);
        			guide1.getStudents().add(student3);
        			guide1.getStudents().add(student4);
        	
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










