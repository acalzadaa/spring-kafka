package com.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.core.model.Greeting;
import com.core.service.ProducerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/app/kafka")
public class ProducerController {
	@Autowired
	ProducerService producerService;

	@Autowired
	public ProducerController(ProducerService producerService) {
		this.producerService = producerService;
	}

	@PostMapping(value = "/text")
	public void sendMessage(@RequestParam("message") String message) {
		this.producerService.sendMessage("text_app", message);
	}

	@PostMapping(value = "/greeting")
	public Greeting sendMessageGreeting(Greeting greet) {
		log.info("Processing: " + greet.toString());
		this.producerService.sendMessageGreeting("greet_app", new Greeting("hello"));
		return greet;
	}

}
