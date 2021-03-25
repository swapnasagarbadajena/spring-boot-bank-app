package com.swapna.banking.dto;

import com.swapna.banking.model.Account;
import com.swapna.banking.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerAccountDetails {
	
	private Customer customer;
	
	private Account account;
	

}
