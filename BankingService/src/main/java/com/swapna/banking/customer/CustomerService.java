package com.swapna.banking.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;


	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customerList = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customerList::add);
		return customerList;
	}

	public List<Customer> getBankCustomers(String bankName) {
		List<Customer> custList = new ArrayList<Customer>();
		customerRepository.findByBankName(bankName).forEach(custList::add);
		return custList;
	}

	public Optional<Customer> getCustomer(String customerId) {
		return customerRepository.findById(customerId);
	}

	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void deleteCustomer(String customerId) {
		customerRepository.deleteById(customerId);
	}

}