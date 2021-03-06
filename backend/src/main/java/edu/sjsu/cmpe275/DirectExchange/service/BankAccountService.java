package edu.sjsu.cmpe275.DirectExchange.service;

import java.util.Optional;
import java.util.Set;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.DirectExchange.model.BankAccount;
import edu.sjsu.cmpe275.DirectExchange.repository.BankAccountRepository;

@Service
public class BankAccountService {

	@Autowired
	public BankAccountRepository bankAccountRepository;
	
	public Optional<BankAccount> getBankAccount(long accountNumber){
		return bankAccountRepository.findById(accountNumber);
	}
	
	public BankAccount saveBankAccount(BankAccount bankAccount){
		return bankAccountRepository.save(bankAccount);
	}
	
	public void deleteBankAccount(long accountNumber) {
		bankAccountRepository.deleteById(accountNumber);
	}
	
	public Set<BankAccount> getCanSend(long id, String country) {
		return bankAccountRepository.canSend(id, country);
	}
	
	public Set<BankAccount> getCanReceive(long id, String country) {
		return bankAccountRepository.canReceive(id, country);
	}
	
	
}