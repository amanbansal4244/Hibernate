package com.javatpoint.mypackage;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
 
public class DeleteStudent {
	
	@SuppressWarnings("unused")
	public void deleteEmployee(Integer empID) {

		//creating configuration object
//		You can enable the interceptor by pass it as an argument to openSession(interceptor)
		Configuration cfg=new AnnotationConfiguration().setInterceptor(new MyInterceptor());
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

		//creating session factory object
		SessionFactory factory=cfg.buildSessionFactory();

		//creating session object
		Session session=factory.openSession();

		//creating transaction object
		Transaction tx= null;
		try {
			tx = session.beginTransaction();

			Student s = (Student)session.get(Student.class, empID);
			
			session.delete(s);
			tx.commit();
		}catch(HibernateException e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}

	}
	public static void main(String[] args) {
		
		//Update employee's records.
				new DeleteStudent().deleteEmployee(2);
	}
}

