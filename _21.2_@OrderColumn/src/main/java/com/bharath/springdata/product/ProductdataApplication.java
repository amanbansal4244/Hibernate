package com.bharath.springdata.product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bharath.springdata.product.entities.Address;
import com.bharath.springdata.product.entities.User;
import com.bharath.springdata.product.repos.UserRepository;


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
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductdataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Cleanup database tables.
		userRepository.deleteAll();

        // Insert a user with multiple phone numbers and addresses.
		List<String> phoneNumbers = new ArrayList<>();
		phoneNumbers.add("+91-9999999999");
		phoneNumbers.add("+91-9898989898");

		Set<Address> addresses = new HashSet<>();
		addresses.add(new Address("747", "Golf View Road", "Bangalore",
                "Karnataka", "India", "560008"));
		addresses.add(new Address("Plot No 44", "Electronic City", "Bangalore",
                "Karnataka", "India", "560001"));

		User user = new User("Rajeev Kumar Singh", "rajeev@callicoder.com",
                phoneNumbers, addresses);

		userRepository.save(user);
	}
}

