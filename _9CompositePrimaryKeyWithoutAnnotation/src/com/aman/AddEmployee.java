package com.aman;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aman.Employee;

public class AddEmployee {

	@SuppressWarnings("unused")
	public Integer addEmployee(String fName, String lName, int salary) {

		//creating configuration object
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

		//creating session factory object
		SessionFactory factory=cfg.buildSessionFactory();

		//creating session object
		Session session=factory.openSession();

		//creating transaction object
		Transaction tx= null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();

			Employee e1=new Employee();
			e1.setId(98); // its gives unique attribute in class to the primary key of the DB table.
			e1.setFirstName(fName);
			e1.setLastName(lName);
			e1.setSalary(salary);
			
			session.save(e1);
			
			tx.commit();
			
	           System.out.println("Object Loaded successfully.....!!");
		}catch(HibernateException e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}

		return employeeID;

	}
	public static void main(String[] args) {
		//Add few employee records in DB.
		new AddEmployee().addEmployee("rahul", "arora", 10);
		new AddEmployee().addEmployee("balli", "sharma", 101);	}
}
