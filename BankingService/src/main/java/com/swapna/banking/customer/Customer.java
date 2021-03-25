package com.swapna.banking.customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.swapna.banking.bank.Bank;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
public class Customer {

	@Id
	private String customerName;

	private String emailId;

	private String mobileNumber;

	private String location;

	@ManyToOne
	private Bank bank;

	public Customer(String customerName, String emailId, String mobileNumber, String location, String bank) {
		super();
		this.customerName = customerName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.location = location;
		this.bank = new Bank(bank,"","");
	}
}
