package com.swapna.banking.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BankService {

	@Autowired
	BankRepository bankRepository;

	public void addBank(Bank bank) {
		bankRepository.save(bank);
	}

	public List<Bank> getAllBanks() {
		List<Bank> companyList = new ArrayList<Bank>();
		bankRepository.findAll().forEach(companyList::add);
		return companyList;
	}

	public Optional<Bank> getBank(String name) {
		return bankRepository.findById(name);
	}

	public void updateBank(String name, Bank bank) {
		bankRepository.save(bank);
	}

	public void deleteBank(String name) {
		bankRepository.deleteById(name);	
	}

}