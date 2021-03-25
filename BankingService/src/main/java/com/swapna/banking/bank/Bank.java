package com.swapna.banking.bank;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Bank {


	@Id
	private String name;

	private String location;

	private String ifscCode;


}
