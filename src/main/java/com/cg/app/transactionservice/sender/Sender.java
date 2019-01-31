package com.cg.app.transactionservice.sender;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.app.transactionservice.entity.Transaction;

@Component
public class Sender {

	@Autowired
	private RabbitMessagingTemplate template;

	public void send(Transaction transaction) {
		template.convertAndSend("transactionQ", transaction);
	}

}
