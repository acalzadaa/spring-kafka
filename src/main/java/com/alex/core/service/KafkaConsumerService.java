package com.alex.core.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumerService {

	@KafkaListener(topics = "test", groupId = "group_id")
	public void consume(String message) {
		log.info(String.format("<TEST> Recibi mensaje -> %s", message));
		System.out.println("Received message from TEST: " + message);
	}

	@KafkaListener(topics = "alex", groupId = "group_id")
	public void listenGroup(String message) {
		log.info(String.format("<ALEX> Recibi mensaje -> %s", message));
		System.out.println("Received message from ALEX: " + message);
	}

}
