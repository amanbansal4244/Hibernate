package com.aman;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class FindEmployee {
	
	public static void main( String[ ] args ) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
		EntityManager entitymanager = emf.createEntityManager();
		
		Employee employee = entitymanager.find( Employee.class, 1 );

		System.out.println("employee ID = " + employee.getId());
		System.out.println("employee first NAME = " + employee.getFirstName());
		System.out.println("employee SALARY = " + employee.getSalary( ));
		System.out.println("employee last name = " + employee.getLastName());
	}
}

