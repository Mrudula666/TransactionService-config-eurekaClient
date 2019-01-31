package com.cg.app.transactionservice.resource;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.app.transactionservice.entity.CurrentDataSet;
import com.cg.app.transactionservice.entity.Transaction;
import com.cg.app.transactionservice.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionResource {

	@Autowired
	private TransactionService service;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/deposit")
	private ResponseEntity<Transaction> deposit(@RequestBody Transaction transaction) {
		System.out.println("Transaction Service");
		ResponseEntity<Double> entity = restTemplate.getForEntity(
				"http://localhost:1122/accounts/" + transaction.getAccountNumber() + "/balance", Double.class);
		System.out.println("helo");
		Double currentBalance = entity.getBody();
		transaction.getTransactionDate();
		Double updatedBalance = service.deposit(transaction.getAccountNumber(), transaction.getAmount(),
				transaction.getTransactionDetails(), LocalDateTime.now(), currentBalance,
				transaction.getTransactionType());
		System.out.println("returnin the current balance" + updatedBalance);
		restTemplate.put("http://localhost:1122/accounts/" + transaction.getAccountNumber() + "?currentBalance="
				+ updatedBalance, null);
		System.out.println("getting updated balance");
		return new ResponseEntity<Transaction>(HttpStatus.CREATED);

	}
	@PostMapping("/withdraw")
	private ResponseEntity<Transaction> withdraw(@RequestBody Transaction transaction) {
		System.out.println("Transaction Service");
		System.out.println(transaction);
		ResponseEntity<Double> entity = restTemplate.getForEntity(
				"http://localhost:1122/accounts/" + transaction.getAccountNumber() + "/balance", Double.class);
		System.out.println("helo");
		Double currentBalance = entity.getBody();
		transaction.getTransactionDate();
		Double updatedBalance = service.withdraw(transaction.getAccountNumber(), transaction.getAmount(),
				transaction.getTransactionDetails(), LocalDateTime.now(), currentBalance,
				transaction.getTransactionType());
		System.out.println("returnin the current balance" + updatedBalance);
		restTemplate.put("http://localhost:1122/accounts/" + transaction.getAccountNumber() + "?currentBalance="
				+ updatedBalance, null);
		System.out.println("getting updated balance");
		return new ResponseEntity<Transaction>(HttpStatus.CREATED);

	}
	@GetMapping
	private ResponseEntity<CurrentDataSet> listOfTransactions() {
		CurrentDataSet currentDataSet = new CurrentDataSet();
		List<Transaction> transactionList = service.getStatements();
		currentDataSet.setTransactions(transactionList);
		return new ResponseEntity<CurrentDataSet>(currentDataSet,HttpStatus.OK);
	}

	

}
