package com.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.core.service.ProducerService;

@RestController
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
		this.producerService.sendMessage(message);
	}
}
