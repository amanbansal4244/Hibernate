package com.aman;

import java.util.Iterator;
import java.util.List;

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
 
public class _3ListAllObjectOfEmployee {
	
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

			/**** HQL uses class name instead of table name, and property names instead of column name. ****/
			String query = "select b from Employee b";
			Query queryObj = session.createQuery(query);
			List list = queryObj.list(); //Using list .. we can return(fetch) multiple records.
			
			//List employees = session.createQuery("FROM Employee").list();
			Iterator itr = list.iterator();
			while(itr.hasNext()) {
				Object o = itr.next();
				/****We need to type cast into POJO class type since we are getting whole POJO class type object. ****/
				Employee employee = (Employee) o;
				System.out.println("Employee First Name:" + employee.getFirstName());
				System.out.println("Employee Last Name:" + employee.getLastName());
				System.out.println("Employee Salary:" + employee.getSalary());
			}
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
		new _3ListAllObjectOfEmployee().listEmployee();
	}
}

