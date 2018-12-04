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
 
public class _11AverageSalaryOfEmployee {
	
	@SuppressWarnings("unused")
	public void averageSalaryOfEmployee() {

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
			/**** HQL uses class name instead of table name, and property names instead of column name. 
			 * we can do all SQL Aggregate functions like avg(), sum(), min(), max(), like() etc.
			 * ****/
			String query = "select avg(salary) from Employee";
			Query queryObj = session.createQuery(query);
			
			double avgSalary = (Double) queryObj.uniqueResult();//Its use for when we fetch only one column or one result using SQL Aggregate functions.
			tx.commit();
			System.out.println("Command successfully executed.");
			System.out.println("Avg Salary:"+ avgSalary);
		}finally {
			session.close();
			factory.close();
		}

	}
	
	public static void main(String[] args) {
		new _11AverageSalaryOfEmployee().averageSalaryOfEmployee();
	}
}

