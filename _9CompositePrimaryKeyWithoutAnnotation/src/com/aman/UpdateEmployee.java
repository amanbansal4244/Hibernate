package com.aman;

import java.util.Iterator;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
 
public class UpdateEmployee {
	
	@SuppressWarnings("unused")
	public void updateEmployee() {

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
			e1.setSalary(101); // if we comments this line then we would get "java.lang.NullPointerException"

			Object o=session.get(Employee.class, e1); // here e1 must be an serializable object,

			Employee p1=(Employee)o;

			p1.setFirstName("aman1");
			//session.update(e);
			tx.commit();//transaction is committed and automatically update method will be called by hibernate.
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
		new UpdateEmployee().updateEmployee();
		new UpdateEmployee().updateEmployee();	

	}
}

