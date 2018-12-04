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
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
 
public class _3MultipleProjectionUsingAdd {
	
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
			ProjectionList projectionList = Projections.projectionList();
			
			projectionList.add(Projections.property("firstName")); 
			projectionList.add(Projections.property("lastName")); 
			
			criteria.setProjection(projectionList);
			
			List list = criteria.list(); //Using list .. we can return(fetch) multiple records.
			
			Iterator itr = list.iterator();
			while(itr.hasNext()) {
				Object[] o = (Object[])itr.next();
				System.out.println("Employee first Name:" + o[0] +"...and .."  + "Employee Last Name:" + o[1]);
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
		new _3MultipleProjectionUsingAdd().listEmployee();
	}
}

