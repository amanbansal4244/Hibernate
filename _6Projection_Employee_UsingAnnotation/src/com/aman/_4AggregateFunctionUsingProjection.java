package com.aman;

import java.util.Iterator;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
 
public class _4AggregateFunctionUsingProjection {
	
	@SuppressWarnings("unused")
	public void listEmployee() {

		//creating configuration object
		Configuration cfg=new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

		//creating session factory object
		SessionFactory factory=cfg.buildSessionFactory();

		//creating session object
		Session session=factory.openSession();

		//creating transaction object
		Transaction tx= null;
		try {
			tx = session.beginTransaction();

			/**** Its create criteria on Employee table and internally fires "select * from Employee" ****/
			Criteria criteria = session.createCriteria(Employee.class);
			/**** We can do all SQL Aggregate functions like avg(), sum(), min(), max(), like() etc using 'Projection'.
			 * ****/
			Projection p = Projections.avg("salary");
			criteria.setProjection(p);
			
			double avgSalary = (Double) criteria.uniqueResult();//Its use for when we fetch only one column or one result using SQL Aggregate functions.
			tx.commit();
			System.out.println("Command successfully executed.");
			System.out.println("Avg Salary:"+ avgSalary);
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
		new _4AggregateFunctionUsingProjection().listEmployee();
	}
}

