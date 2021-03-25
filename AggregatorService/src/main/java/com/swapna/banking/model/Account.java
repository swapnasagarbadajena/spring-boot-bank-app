package com.swapna.banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	private String customerName;

	private Long accountNumber;

	private Double balance;



}
