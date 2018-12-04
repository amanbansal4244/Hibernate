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
import org.hibernate.criterion.Restrictions;
 
public class _8GreaterThanAndEqualsToOperatorOfCriteriaOnEmployee {
	
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
			/**** Its create 'criteria' on Employee table and internally fires "select * from Employee" ****/
			Criteria criteria = session.createCriteria(Employee.class);
			/**** Using 'criteria', we can't put any filter, to apply filter, we need to use 'Criterion' ****/
			Criterion cn =  Restrictions.ge("salary", 2000);//Make sure the 'salary' is greater than or equal to 20000.


			criteria.add(cn);
			
			List list = criteria.list(); //Using list .. we can return(fetch) multiple records.
			
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
		new _8GreaterThanAndEqualsToOperatorOfCriteriaOnEmployee().listEmployee();
	}
}

