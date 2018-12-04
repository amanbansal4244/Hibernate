package com.bharath.springdata.transactionmanagement;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bharath.springdata.transactionmanagement.services.BankAccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionmanagementApplicationTests {
	
	@Autowired
	BankAccountService service;

	@Test
	public void testTransfer() {
		try {
			service.transfer(500);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
