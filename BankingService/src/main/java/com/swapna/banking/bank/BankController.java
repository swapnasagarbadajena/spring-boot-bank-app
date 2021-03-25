package com.swapna.banking.bank;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/profile")
public class BankController {

	@Autowired
	BankService bankService;


	@GetMapping("/helloUser")
	public String sayHelloUser() {
		return "Hello User! Welcome to Bank";
	}

	@PostMapping("/banks")
	public void addBank(@RequestBody Bank bank) {
		bankService.addBank(bank);
	}

	@GetMapping("/banks")
	public List<Bank> getAllBanks() {
		return bankService.getAllBanks();
	}

	@GetMapping("/banks/{bankName}")
	public Optional<Bank> getBank(@PathVariable String bankName){
		System.out.println("Inside getBank");
		return bankService.getBank(bankName);
	}

	@PutMapping("/banks/{bankName}")
	public void updateBank(@RequestBody Bank bank, @PathVariable String bankName) {
		System.out.println("inside updateBank");
		bankService.updateBank(bankName, bank);
	}

	@DeleteMapping("/banks/{bankName}")
	public void deleteBank(@PathVariable String bankName){
		System.out.println("Inside deleteBank");
		bankService.deleteBank(bankName);
	}

	@GetMapping("/banks/bankSeedData")
	public void seedData(){

		System.out.println("Inside Bank seedData");

		bankService.addBank(new Bank("SBI", "Hyderabad", "SBI0001122"));
		bankService.addBank(new Bank("HDFC", "Bangalore", "HDFC0004456"));
		bankService.addBank(new Bank("ICICI", "New Delhi", "ICICI0001122"));
		bankService.addBank(new Bank("HSBC", "Kerala", "HSB0001135"));
	}
}