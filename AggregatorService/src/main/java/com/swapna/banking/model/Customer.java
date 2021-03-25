package com.swapna.banking.model;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class Customer {


	private String customerName;

	private String emailId;

	private String mobileNumber;

	private String location;

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