package com.core.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerService {

	@KafkaListener(topics = "test", groupId = "first")
	public void consume(String message) {
		log.debug(String.format("Received the following message [ %s ]", message));
		System.out.println("Received the following message: " + message);
	}
}
