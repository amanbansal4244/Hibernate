package com.aman;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
 
public class _9UpdateEmployee {
	
	@SuppressWarnings("unused")
	public void updateEmployee(Integer empID, int salary) {

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
			String query = "update Employee e set e.salary= ? where e.id=:iddd"; 
			Query queryObj = session.createQuery(query);
			queryObj.setParameter("iddd", empID);
			queryObj.setParameter(0, salary);
			
			int result = queryObj.executeUpdate();//Its use for DML operation and returns, how many records gets effected.
			tx.commit();
			System.out.println("Command successfully executed.");
			System.out.println("Numbers of records effected due to update query:"+ result);
		}finally {
			session.close();
			factory.close();
		}

	}
	
	public static void main(String[] args) {
		new _9UpdateEmployee().updateEmployee(28,50000);
	}
}

