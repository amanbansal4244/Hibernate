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
 
public class _4ListPartialObjectOfEmployee {
	
	@SuppressWarnings("unused")
	public void listEmployee() {

		//creating configuration object
		Configuration cfg=new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

		//creating session factory object
		SessionFactory factory=cfg.buildSessionFactory();

		//creating session object
		Session session=factory.openSession();

		try {
			/**** HQL uses class name instead of table name, and property names instead of column name. ****/
			String query = "select e.firstName, e.lastName from Employee e";
			Query queryObj = session.createQuery(query);
			List list = queryObj.list(); //Using list .. we can return(fetch) multiple records.
			
			//List employees = session.createQuery("FROM Employee").list();
			Iterator itr = list.iterator();
			while(itr.hasNext()) {
				/****We need to type cast into Object class type array since we are fetching multiple values. ****/
				Object o[] = (Object[])itr.next();
				System.out.println("Employee First Name:" + o[0]);
				System.out.println("Employee Last Name:" + o[1]);
			}
			
		}finally {
			session.close();
		}

	}
	
	public static void main(String[] args) {
		new _4ListPartialObjectOfEmployee().listEmployee();
	}
}

