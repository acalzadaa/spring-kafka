package com.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.core.model.Customer;
import com.core.service.KafkaProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

	@Autowired
	KafkaProducerService producerService;

	@Autowired
	public KafkaController(KafkaProducerService producerService) {
		this.producerService = producerService;
	}

	@PostMapping(value = "/publish")
	public String sendMessageToKafkaTopic(@RequestParam("message") String message) {
		this.producerService.sendMessage(message);
		return "El controller recibio este Mensaje: " + message;
	}

	@PostMapping(value = "/customer")
	public Customer sendMessageToCustomerToKafkaTopic(Customer customer) {
		System.out.println("Me llego este mensaje!! " + customer.toString());
		this.producerService.sendCustomerMessage(new Customer("uno", "dos", "tres"));
		return new Customer("Uno", "Dos", "Tres");
	}

}
