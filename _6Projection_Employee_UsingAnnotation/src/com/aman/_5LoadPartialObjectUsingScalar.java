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
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
 
public class _5LoadPartialObjectUsingScalar {
	
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
			
			/**** If we add multiple projection to 'Criteria' then the last projection added will be considered to execute.
			 * means last Projection will over-ride others above projection, means we should not used 'setProjection' for multiple projection to 'Criteria'
			 * we always should use 'add' for multiple projection to 'Criteria'.
			 *  ****/
			criteria.setProjection(Projections.property("firstName")); 
			criteria.setProjection(Projections.property("lastName")); 
			
			List list = criteria.list(); //Using list .. we can return(fetch) multiple records.
			
			/*//Get All Employees - addScalar example
			SQLQuery query = session.createSQLQuery("select emp_id, emp_name, emp_salary from Employee")
					.addScalar("emp_id", new LongType())
					.addScalar("emp_name", new StringType())
					.addScalar("emp_salary", new DoubleType());*/
			
			/*List<Object[]> rows = query.list();
			for(Object[] row : rows){
				Employee emp = new Employee();
				emp.setId(Long.parseLong(row[0].toString()));
				emp.setName(row[1].toString());
				emp.setSalary(Double.parseDouble(row[2].toString()));
				System.out.println(emp);
			}*/
			
			Iterator itr = list.iterator();
			while(itr.hasNext()) {
				String o = (String)itr.next();
				System.out.println("Employee last Name:" + o);
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
		new _5LoadPartialObjectUsingScalar().listEmployee();
	}
}

