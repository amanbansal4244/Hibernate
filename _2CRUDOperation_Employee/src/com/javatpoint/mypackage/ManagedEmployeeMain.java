package com.javatpoint.mypackage;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManagedEmployeeMain {

	private static SessionFactory factory;
	
	public static void main(String[] args) {
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory."+ ex);
			
		}
		
		ManagedEmployeeMain employeeMain = new ManagedEmployeeMain();
		
		//Add few employee records in DB.
		Integer empID1 = new AddEmployee().addEmployee("Zara", "Ali", 10);
		Integer empID2 = new AddEmployee().addEmployee("Zara1", "Ali1", 101);
		
		System.out.println("Records Inserted!");
		
		//List Down all the employees.
		System.out.println("List of employees...................");
		new ListEmployee().listEmployee();
		
		//Update employee's records.
		new UpdateEmployee().updateEmployee(empID2, 200);
		System.out.println("Records Updated!");
		
		
		//List Down all the employees.
		System.out.println("List of employees...................");
		new ListEmployee().listEmployee();
		
		//Delete an employee from the DB
		new DeleteEmployee().deleteEmployee(empID2);
		System.out.println("Records Deleted!");
		
		//List Down all the employees.
		System.out.println("List of employees...................");
		new ListEmployee().listEmployee();
	}
}
