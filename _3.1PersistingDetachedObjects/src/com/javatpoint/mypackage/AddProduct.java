package com.javatpoint.mypackage;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.javatpoint.mypackage.Product;

public class AddProduct {

	@SuppressWarnings("unused")
	public Integer addProduct() {

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

			Product e1=new Product();
			e1.setId(22);
			e1.setPrice("30000");

			session.save(e1); 
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
		
		new AddProduct().addProduct();
		
		System.out.println("Records Inserted!");
		
	}
}
