package com.swapna.banking.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bank {

	private String name;

	private String location;

	private String ifscCode;


}