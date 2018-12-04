package com.bharath.springdata.transactionmanagement.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bharath.springdata.transactionmanagement.entities.BankAccount;
import com.bharath.springdata.transactionmanagement.repos.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepository repository;

	@Override
	//@Transactional(rollbackFor = Exception.class)
	@Transactional(isolation=Isolation.REPEATABLE_READ)
	public void transfer(int amount) throws IOException {

		BankAccount obamasAccount = repository.findOne(1);
		obamasAccount.setBal(obamasAccount.getBal() - amount);
		repository.save(obamasAccount);

		if (true) {
			throw new IOException();
		}

		BankAccount trumpsAccount = repository.findOne(2);
		trumpsAccount.setBal(trumpsAccount.getBal() + amount);
		repository.save(trumpsAccount);

	}

}
