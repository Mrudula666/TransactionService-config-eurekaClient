package com.cg.app.transactionservice.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.app.transactionservice.entity.Transaction;

public interface TransactionService {

	Double deposit(Integer accountNumber, Double amount, String transactionDetails, LocalDateTime transactionDate,
			Double currentBalance, String string);

	Double withdraw(Integer accountNumber, Double amount, String transactionDetails, LocalDateTime now,
			Double currentBalance, String transactionType);

	List<Transaction> getStatements();

}