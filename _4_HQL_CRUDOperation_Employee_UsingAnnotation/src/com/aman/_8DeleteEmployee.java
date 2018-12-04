package com.aman;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
 
public class _8DeleteEmployee {
	
	@SuppressWarnings("unused")
	public void deleteEmployee(Integer empID) {

		//creating configuration object
		Configuration cfg=new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

		//creating session factory object
		SessionFactory factory=cfg.buildSessionFactory();

		//creating session object
		Session session=factory.openSession();

		Transaction tx= null;
		try {
			tx = session.beginTransaction();
			/**** HQL uses class name instead of table name, and property names instead of column name. ****/
			String query = "delete from Employee e where e.id=:iddd"; 
			Query queryObj = session.createQuery(query);
			queryObj.setParameter("iddd", empID);
			
			int result = queryObj.executeUpdate();//Its use for DML operation and returns, how many records gets effected.
			tx.commit();
			System.out.println("Command successfully executed.");
			System.out.println("Numbers of records effected due to delete query:"+ result);
		}finally {
			session.close();
			factory.close();
		}

	}
	
	public static void main(String[] args) {
		new _8DeleteEmployee().deleteEmployee(27);
	}
}

