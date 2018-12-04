package com.bharath.springdata.transactionmanagement.services;

import java.io.IOException;

public interface BankAccountService {
	
	void transfer(int amount) throws IOException;

}
