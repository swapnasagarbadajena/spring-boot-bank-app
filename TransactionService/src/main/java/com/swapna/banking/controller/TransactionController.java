package com.swapna.banking.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swapna.banking.model.Account;
import com.swapna.banking.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	

	@Autowired
	TransactionService transactionService;

	@GetMapping("/hello")
	public String welcomeUser() {
		return "Hello User! Welcome to India Bank Transactions";
	}
	
	@PostMapping("/accounts/{customerId}")	
	public void createAccount(@RequestBody Account account) {
		System.out.println("Inside createAccount method");
		transactionService.createAccount(account);
	}
	
	@GetMapping("/accounts/{customerId}")
	public Optional<Account> getAccountDetails(@PathVariable String customerId) {
		System.out.println("Inside getCustomerAccount method");
		return transactionService.getAccountDetails(customerId);
	}
	
	@PutMapping("/accounts/deposit")	
	public String depositAmount(@RequestBody Account account) {
		System.out.println("Inside depositAmount method");
		Double bal = transactionService.depositAmount(account);
		return "Your amount has been deposited successfully. Your new Balance is Rs: " + bal;
	}
	
	
	@PutMapping("/accounts/withdraw")
	public String withdrawAmount(@RequestBody Account account) {
		System.out.println("Inside withdrawAmount method");
		Double bal = transactionService.withdrawAmount(account);
		return "Your amount withdrawn is successful. Your new Balance is Rs: " + bal;
	}
	
	
	@GetMapping("/accounts/balance/{accNo}")
	public Double getBalance(@PathVariable Long accNo) {
		System.out.println("Inside getBalance method");
		return transactionService.getBalance(accNo);
	}
	
	
	@GetMapping("/accounts/seedData")
	public void customerAccountSeedData(){
		System.out.println("Inside customerAccountSeedData method");
		transactionService.createAccount(new Account("Imran",0L, 52000.70));
		transactionService.createAccount(new Account("Vilas",0L, 25000.50));
		transactionService.createAccount(new Account("Swapna",0L, 2000.20));
		transactionService.createAccount(new Account("Nagendra",0L, 1000.10));
		transactionService.createAccount(new Account("John",0L, 500.00));
		transactionService.createAccount(new Account("Sai",0L, 200.55));
		transactionService.createAccount(new Account("Abraham",0L, 100.15));
	}
}