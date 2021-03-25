package com.swapna.banking.dto;

import java.util.List;

import com.swapna.banking.model.Customer;

import lombok.Data;


@Data
public class BankCustomers {
	
	List<Customer> customerList;

}
