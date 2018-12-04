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
			/****
			 * We should set the Id if PK is natural key (means Key values have business meaning like 'login id')
			 * We don't need to set the Id if PK is Surrogate key (means Key values does not have business,its just for new id for sequence )
			 * hibernate will take care of Surrogate key.
			 */
			e1.setId(5335);
			
			e1.setFirstName(fName);
			e1.setLastName(lName);
			e1.setSalary(salary);
			e1.setFatherName("Ramesh");
			e1.setAge(45);
			e1.setDescription("dddddddddddddddddddddddddddddddd");
			e1.setJoinedDate(new Date());
			e1.setLastDate(new Date());

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
