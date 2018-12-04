
package com.aman;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aman.Guide;
import com.aman.Student;

public class GetStudentObjectOnly {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		try {
			txn.begin();

			/**** HQL uses class name instead of table name, and property names instead of column name. ****/
			/*String query = "select s from Student s";
			Query queryObj = session.createQuery(query);
			List list = queryObj.list(); //Using list .. we can return(fetch) multiple records.

			//Loading all the student objects
			Iterator itr = list.iterator();
			while(itr.hasNext()) {
				Object o = itr.next();
				*//****We need to type cast into POJO class type since we are getting whole POJO class type object. ****//*
				Student student = (Student) o;
				if(student.getGuide()!=null) {
					System.out.println("Student Name:" + student.getName());
					System.out.println("Student Enrollment Id:" + student.getEnrollmentId());
					System.out.println("Student Guide Name Id:" + student.getGuide().getName());
				}
			}*/


			//Loading all the students with their associated Guide objects with the Student objects selectively (whenever you need to load them eagerly)
			String query = "select student from Student student left join fetch student.guide";
			Query queryObj = session.createQuery(query);
			List list = queryObj.list(); //Using list .. we can return(fetch) multiple records.

			//Loading all the student objects
			Iterator itr = list.iterator();
			while(itr.hasNext()) {
				Object o = itr.next();
				/****We need to type cast into POJO class type since we are getting whole POJO class type object. ****/
				Student student = (Student) o;
				if(student.getGuide()!=null) {
					System.out.println("Student Name:" + student.getName());
					System.out.println("Student Enrollment Id:" + student.getEnrollmentId());
					System.out.println("Student Guide Name Id:" + student.getGuide().getName());
				}
			}	
			 

			txn.commit();			
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
}














