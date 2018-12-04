package com.aman;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.aman.Employee;

public class AddEmployee {

	@SuppressWarnings("unused")
	public Integer addEmployee(String fName, String lName, int salary) {

		Configuration cfg=new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx= null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();

			Employee e1=new Employee();
			Address a1 = new Address();
			a1.setCity("Pune");
			a1.setState("MH");
			a1.setStreetName("Home");
			a1.setZipcode("411013");
			
			Address a2 = new Address();
			a2.setCity("Office_Pune");
			a2.setState("Maharastra");
			a2.setStreetName("Office");
			a2.setZipcode("411028");
			
			Project p1 = new Project();
			p1.setProjectName("P1 Project");
			Project p2 = new Project();
			p2.setProjectName("P2 Project");
			Project p3 = new Project();
			p3.setProjectName("P3 Project");
			
			e1.getListOfAddress().add(a1);
			e1.getListOfAddress().add(a2);
			e1.getListOfProject().add(p1);
			e1.getListOfProject().add(p2);
			e1.getListOfProject().add(p3);
			
			e1.setId(55);
			e1.setName("aman");
			
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

	public static void main(String[] args) {
		//Add few employee records in DB.
		new AddEmployee().addEmployee("Zara", "Ali", 100000);
		new AddEmployee().addEmployee("Zara1", "Ali1", 1010000);
	}
}
