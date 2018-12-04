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
 
public class ListEmployee {

	@SuppressWarnings("unused")
	public void listEmployee() {

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

			/****
			 * For loading an object we have to pass the primary key column value like…
					Object o=session.get(Employee.class, new Integer(98));
				--->Actually that is the case with single primary key, but see in this example we are using multiple primary keys (2 primary key values), so while loading an object how we will give two values….?
					Object o=session.get(Employee.class, new Integer(98,101));
		 		---> which is absolutely wrong……………!!!!!!!!!
				so how we can pass the multiple primary key values for loading that object.. ?
				First we need to set the values just like in line numbers 58,59 , ensure you are setting the values which already have in the database for that particular object.
				Then we need to pass that object as the parameter to load the object.
					Object o=session.get(Employee.class, p);
				What am saying is that the second parameter of the get method is always a Serializable object, so in the Employee.java line just implemented with java.io.Serializable
				Remember, if we have single primary key we used to give
					Object o=session.get(Employee.class, new Integer(98));
				here new Integer(98) is the wrapper, all wrappers are Serializable by default.
			 */
			Employee e1=new Employee();
			e1.setId(98); // its gives unique attribute in class to the primary key of the DB table.
			e1.setSalary(101); // if we comments this line then we would get "java.lang.NullPointerException"

			Object o=session.get(Employee.class, e1); // here e1 must be an serializable object,

			Employee p1=(Employee)o;

			System.out.println("The last name is: "+p1.getLastName());     

			System.out.println("Object Loaded successfully.....!!");
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
		new ListEmployee().listEmployee();
		new ListEmployee().listEmployee();	

	}
}


