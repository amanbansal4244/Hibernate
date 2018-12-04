package com.aman;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
 
public class DeleteEmployee {
	
	@SuppressWarnings("unused")
	public void deleteEmployee() {

		//creating configuration object
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

		//creating session factory object
		SessionFactory factory=cfg.buildSessionFactory();

		//creating session object
		Session session=factory.openSession();

		//creating transaction object
		Transaction tx= null;
		try {
			tx = session.beginTransaction();

			Employee e1=new Employee();
			e1.setId(98); // its gives unique attribute in class to the primary key of the DB table.
			e1.setSalary(10); // if we comments this line then we would get "java.lang.NullPointerException"

			Object o=session.get(Employee.class, e1); // here e1 must be an serializable object,

			Employee p1=(Employee)o;
			
			session.delete(p1);
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
		new DeleteEmployee().deleteEmployee();
		new DeleteEmployee().deleteEmployee();	

	}
}

