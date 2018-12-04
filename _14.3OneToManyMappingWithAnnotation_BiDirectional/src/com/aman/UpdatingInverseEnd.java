package com.aman;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdatingInverseEnd {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		try {
			txn.begin();


			//Updating inverse end

			Guide guide = (Guide) session.get(Guide.class, 2L);        	
			Student student = (Student) session.get(Student.class, 2L);          	
			guide.getStudents().add(student);


			//Updating owner

			/* 	Guide guide = (Guide) session.get(Guide.class, 2L);        	
        	Student student = (Student) session.get(Student.class, 2L);          	
        	student.setGuide(guide);
			 */	     	

			//Updating inverse end (after adding addStudent(Student) in Guide entity)
			/*
        	Guide guide = (Guide) session.get(Guide.class, 2L);        	
        	Student student = (Student) session.get(Student.class, 1L);          	
        	guide.addStudent(student);
			 */

			txn.commit();
		}	catch(Exception e) {
			if(txn != null) { txn.rollback(); }
			e.printStackTrace();
		}	finally {
			if(session != null) { session.close(); }
		}

	}
}
