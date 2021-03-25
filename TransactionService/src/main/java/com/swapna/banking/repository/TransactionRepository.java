package com.swapna.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swapna.banking.model.Account;

public interface TransactionRepository extends JpaRepository<Account, String> {

	Account findByAccountNumber(Long accountNumber);

		
	
}
