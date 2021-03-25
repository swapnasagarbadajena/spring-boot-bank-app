package com.swapna.banking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapna.banking.model.Account;
import com.swapna.banking.model.RandomUtil;
import com.swapna.banking.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepo;

	public void createAccount(Account account) {
		Long accountNumber = RandomUtil.generateAccountNumber();
		account.setAccountNumber(accountNumber);
		//account.setBalance(500.00);
		transactionRepo.save(account);
	}

	public Optional<Account> getAccountDetails(String customerId) {
		return transactionRepo.findById(customerId);
	}

	public Double depositAmount(Account account) {
		Account custAcc = transactionRepo.findByAccountNumber(account.getAccountNumber());
		Double oldBal = custAcc.getBalance();
		Double newBal = oldBal + account.getBalance();
		account.setBalance(newBal);
		Account accBal = transactionRepo.save(account);
		return accBal.getBalance();
	}

	public Double withdrawAmount(Account account) {
		Account custAcc = transactionRepo.findByAccountNumber(account.getAccountNumber());
		Double oldBal = custAcc.getBalance();
		Double newBal = oldBal - account.getBalance();
		account.setBalance(newBal);
		Account accBal = transactionRepo.save(account);
		return accBal.getBalance();
	}

	public Double getBalance(Long accountNumber) {
		Account custAcc = transactionRepo.findByAccountNumber(accountNumber);
		return custAcc.getBalance();
	}
	
	
	
	
	
	
	

}
