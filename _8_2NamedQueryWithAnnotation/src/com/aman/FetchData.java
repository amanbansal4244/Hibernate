package com.aman;

import java.util.Iterator;
import java.util.List;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.*;

public class FetchData {
	public static void main(String[] args) {

		AnnotationConfiguration configuration=new AnnotationConfiguration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sFactory=configuration.buildSessionFactory();
		Session session=sFactory.openSession();
				
		//Hibernate Named Query
		Query query = session.getNamedQuery("findEmployeeByName");
		query.setString("name", "amit");
		
		List<Employee> employees=query.list();
		
		Iterator<Employee> itr=employees.iterator();
		while(itr.hasNext()){
		Employee e=itr.next();
		System.out.println(e);
		}
		
		session.close();
	
	}

}
