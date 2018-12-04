package com.aman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class CompositeKey_Embeddable_Example
{
	public static void main(String args[])
	{
		//creating configuration object
		Configuration cfg=new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

		//creating session factory object
		SessionFactory factory=cfg.buildSessionFactory();

		//creating session object
		Session session=factory.openSession();

		//creating transaction object
		Transaction tx= null;
		tx = session.beginTransaction();

		//Create a new Employee object
		Employee employee = new Employee();

		EmployeeId employeeId = new EmployeeId(1,"Blogging");
		employee.setEmpName("JavaInterviewPoint");
		employee.setId(employeeId);

		session.save(employee);

		//Retrieve Employee Details
		Employee employee1 = (Employee) session.get(Employee.class, employeeId);
		System.out.println("*** Employee Details ***");
		System.out.println("Employee Id   : "+employee1.getId().getEmpId());
		System.out.println("Employee Name : "+employee1.getEmpName());
		System.out.println("Department    : "+employee1.getId().getDepartment());

		//Commit the changes
		session.getTransaction().commit();
		//Close the session
		session.close();
	}
}