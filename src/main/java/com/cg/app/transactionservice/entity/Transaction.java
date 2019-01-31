package com.cg.app.transactionservice.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//Auto Generation of PK
	private Integer transactionId;
	private Integer accountNumber;
	private Double amount;
	private String transactionType;
	//@Temporal(TemporalType.DATE)
	private LocalDateTime transactionDate;
	private String transactionDetails;
	private Double currentBalance;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public Transaction(Integer accountNumber, Double amount, String transactionType,
			String transactionDetails) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.transactionType = transactionType;
		this.transactionDetails = transactionDetails;
	}
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionDetails() {
		return transactionDetails;
	}
	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	public Double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountNumber=" + accountNumber + ", amount=" + amount
				+ ", transactionType=" + transactionType + ", transactionDate=" + transactionDate
				+ ", transactionDetails=" + transactionDetails + ", currentBalance=" + currentBalance + "]";
	}

}
