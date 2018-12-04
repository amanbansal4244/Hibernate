package com.aman;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddEmployee {

	@SuppressWarnings("unused")
	public void  addEmployee( String fName, String lName, int salary) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Employee e1=new Employee();
		e1.setFirstName(fName);
		e1.setLastName(lName);
		e1.setSalary(salary);

		em.persist(e1);

		em.getTransaction().commit();
		System.out.println("Persisted " + e1);

	}
	public static void main(String[] args) {
		new AddEmployee().addEmployee("Deepak", "Bansal", 100000);
	}
}
