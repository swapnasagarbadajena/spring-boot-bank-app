package com.swapna.banking.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {

	@Id
	private String customerName;
	
	private Long accountNumber;

	private Double balance;

	//private Date createdDate;

}
