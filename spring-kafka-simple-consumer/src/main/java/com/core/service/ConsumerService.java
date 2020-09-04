package com.core.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerService {

	@KafkaListener(topics = "test", groupId = "first")
	public void consume(@Payload String message,
			@Header(name = KafkaHeaders.RECEIVED_MESSAGE_KEY, required = false) String key,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts) {

		log.info(String.format("Payload [ %s ]", message));
		log.info(String.format("Key [ %s ]", key));
		log.info(String.format("Partition [ %s ]", partition));
		log.info(String.format("Topic [ %s ]", topic));
		log.info(String.format("Timestamp [ %s ]", ts));

		System.out.println("Received: [" + key + ":" + message + "]");

	}

}
