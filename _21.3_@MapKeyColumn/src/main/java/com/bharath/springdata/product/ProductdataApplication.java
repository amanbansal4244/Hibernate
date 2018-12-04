package com.bharath.springdata.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bharath.springdata.product.entities.Employee;
import com.bharath.springdata.product.entities.Phone;
import com.bharath.springdata.product.repos.EmployeeRepository;


/****
 * The main class implements the CommandLineRunner interface and provides the implementation of its run() method.

The run() method is executed post application startup. In the run() method, we first cleanup all the tables and 
then insert a new user with multiple phone numbers and addresses.
 * @author bansal
 *
 */
@SpringBootApplication
public class ProductdataApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository empRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductdataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Cleanup database tables.
		empRepository.deleteAll();

		Employee emp = new Employee();
		emp.setFirstName("Prasad");
		emp.setLastName("Kharkar");
 
		Phone phone1 = new Phone();
		phone1.setOwner(emp);
		phone1.setPhoneNumber("53434524");
		phone1.setProvider("Airtel");
 
		Phone phone2 = new Phone();
		phone2.setOwner(emp);
		phone2.setProvider("bsnl");
		phone2.setPhoneNumber("56252314");
		emp.getPhones().put("Home", phone1);
		emp.getPhones().put("Work", phone2);
 
		empRepository.save(emp);
 
		emp = new Employee();
		emp.setFirstName("Sushant");
		emp.setLastName("Pangarkar");
 
		Phone phone3 = new Phone();
		phone3.setOwner(emp);
		phone3.setPhoneNumber("8795656");
		phone3.setProvider("Idea");
 
		Phone phone4 = new Phone();
		phone4.setOwner(emp);
		phone4.setPhoneNumber("0165410254");
		phone4.setProvider("Reliance");
 
		emp.getPhones().put("Home", phone3);
		emp.getPhones().put("Work", phone4);
		
		empRepository.save(emp);

	}
}

