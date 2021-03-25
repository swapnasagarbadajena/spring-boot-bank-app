package com.swapna.banking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.swapna.banking.dto.BankCustomers;
import com.swapna.banking.dto.CustomerAccountDetails;
import com.swapna.banking.model.Account;
import com.swapna.banking.model.Customer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/aggregator")
public class BankAggregatorController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/hello")
	public String welcomeUser() {
		return "Hello User! Welcome to India Bank Aggregator";
	}

	@GetMapping("/banks/{bankName}")
	@CircuitBreaker(name = "BANKAGGREGATOR", fallbackMethod = "fallbackAccDetails")
	public List<CustomerAccountDetails> getAllCustomerAccountDetails(@PathVariable String bankName){
		System.out.println("Entering BANKAGGREGATOR getAccountDetails method");
		BankCustomers bankCustomers = restTemplate.getForObject("http://BANKPROFILE/profile/banks/"+bankName+"/customers", BankCustomers.class);
		List<Customer> custList = bankCustomers.getCustomerList();
		List<CustomerAccountDetails> custAccDetailsList = new ArrayList<CustomerAccountDetails>();
		for (Customer cust : custList) {
			Account acc = restTemplate.getForObject("http://BANKTRANSACTION/transaction/accounts/"+cust.getCustomerName(), Account.class);
			custAccDetailsList.add(new CustomerAccountDetails(cust, acc));
		}
		System.out.println("Exiting BANKAGGREGATOR getAccountDetails method");
		return custAccDetailsList;
	}

	public List<CustomerAccountDetails> fallbackAccDetails(@PathVariable String bankName, Exception e){
		List<CustomerAccountDetails> custAccDetailList = new ArrayList<CustomerAccountDetails>();
		custAccDetailList.add(new CustomerAccountDetails(new Customer("India Banks Customer", "customer@indiabanks.com", "9812345672", "India", bankName), new Account("India Banks Customer", 337725789123L, 12570.50)));
		System.out.println("Exception :" + e);
		return custAccDetailList;
	}
}