package com.cg.app.transactionservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.transactionservice.entity.Transaction;
import com.cg.app.transactionservice.entity.TransactionType;
import com.cg.app.transactionservice.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository repository;

	@Autowired
	private Transaction transaction ;
	@Override
	public Double deposit(Integer accountNumber, Double amount, String transactionDetails,
			LocalDateTime transactionDate, Double currentBalance, String string) {
		transaction.setAccountNumber(accountNumber);
		transaction.setAmount(amount);
		transaction.setTransactionDetails("ATM");
		transaction.setTransactionDate(transactionDate);
		currentBalance +=amount;
		transaction.setCurrentBalance(currentBalance);
		transaction.setTransactionType(TransactionType.DEPOSIT);
		Double updatedCurrentBalance = repository.save(transaction).getCurrentBalance();
		return updatedCurrentBalance;
		
	}


	@Override
	public Double withdraw(Integer accountNumber, Double amount, String transactionDetails, LocalDateTime now,
			Double currentBalance, String transactionType) {
		
		transaction.setAccountNumber(accountNumber);
		transaction.setAmount(amount);
		transaction.setTransactionDetails("ATM");
		transaction.setTransactionDate(now);
		currentBalance -=amount;
		transaction.setCurrentBalance(currentBalance);
		transaction.setTransactionType(TransactionType.WITHDRAW);
		Double updatedCurrentBalance = repository.save(transaction).getCurrentBalance();
		return updatedCurrentBalance;
	}


	@Override
	public List<Transaction> getStatements() {
		
		return repository.findAll();
	}

}
