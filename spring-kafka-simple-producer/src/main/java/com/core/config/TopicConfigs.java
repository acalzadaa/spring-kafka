package com.core.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfigs {

	@Value(value = "${spring.kafka.producer.bootstrap-servers}")
	private String bootstrapAddress;

	@Value("${spring.kafka.topic.general}")
	private String topicNameGeneral;

	@Value("${spring.kafka.topic.greeting}")
	private String topicNameGreeting;

	@Bean
	public NewTopic generalTopic() {
		return TopicBuilder.name(topicNameGeneral).partitions(1).replicas(1).build();
	}

	@Bean
	public NewTopic greetingsTopic() {
		return TopicBuilder.name(topicNameGreeting).partitions(1).replicas(1).build();
	}
}
