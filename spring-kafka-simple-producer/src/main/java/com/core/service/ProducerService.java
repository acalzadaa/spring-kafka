package com.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.core.model.Greeting;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProducerService {

	@Value("${spring.kafka.topic.general}")
	private String topicNameGeneral;

	@Value("${spring.kafka.topic.greeting}")
	private String topicNameGreeting;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private KafkaTemplate<String, Greeting> kafkaTemplateGreeting;

	public void sendMessage(String key, String message) {
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicNameGeneral, key, message);

		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

			@Override
			public void onSuccess(SendResult<String, String> result) {
				log.info(String.format("Sent this message: [ %s ] ", message));
				log.info(result.getProducerRecord().toString());
				log.info(result.getRecordMetadata().toString());
				System.out.println("Sent this message: [ " + message + " ] ");
			}

			@Override
			public void onFailure(Throwable ex) {
				log.info(String.format("Unable to send message: [ %s ] ", message));
				System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
			}
		});
	}

	public void sendMessageGreeting(String key, Greeting greet) {
		ListenableFuture<SendResult<String, Greeting>> future = this.kafkaTemplateGreeting.send(topicNameGreeting, key,
				greet);

		future.addCallback(new ListenableFutureCallback<SendResult<String, Greeting>>() {
			@Override
			public void onSuccess(SendResult<String, Greeting> result) {
				log.info("Sent greeting: " + greet.toString() + " with offset: " + result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				log.error("Unable to send message : " + greet.toString(), ex);
			}
		});
	}

}
