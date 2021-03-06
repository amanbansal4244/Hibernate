package com.javatpoint.mypackage;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.javatpoint.mypackage.Employee;

public class AddEmployee {

	@SuppressWarnings("unused")
	public Integer addEmployee(String fName, String lName, int salary) {

		//creating configuration object
		Configuration cfg=new AnnotationConfiguration();
		/**** Add below commented line or add entry :  <mapping class="com.javatpoint.mypackage.Employee" /> in "hibernate.cfg.xml" file****/
		//((AnnotationConfiguration) cfg).addAnnotatedClass(com.javatpoint.mypackage.Employee.class);
		
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
			e1.setFirstName(fName);
			e1.setLastName(lName);
			e1.setSalary(salary);

			employeeID = (Integer)session.save(e1); 
			tx.commit();
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
}
