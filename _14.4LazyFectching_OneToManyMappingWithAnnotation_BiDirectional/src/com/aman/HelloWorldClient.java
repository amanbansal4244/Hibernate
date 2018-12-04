
package com.aman;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aman.Guide;
import com.aman.Student;

public class HelloWorldClient {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		Set<Student> students = null;
		try {
			txn.begin();
				//Lazy Collection Fetching with default settings(fetch=FetchType.LAZY for collection associations)
        			//Guide guide = (Guide) session.get(Guide.class, 2L);
        			//students =  guide.getStudents();
        			//int numberOfStudents = students.size(); 
            		 

					//Eager Fetching with default settings (fetch=FetchType.EAGER for single point associations)
					Student student = (Student) session.get(Student.class, 2L);
  
	        		txn.commit();
	        		session.close();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}
		
	}
}






