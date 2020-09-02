# Apache Kafka

This project intents to explore all there is to know about kafka. I'll start creating a docker-compose to fire up kafka and start experimenting.

## Running Kafka

### Fire up kafka, zookeeper and kafdrop

- In the root of the project, execute: *docker-compose up*

### Check Kafka status use kafdrop

- Point up your browser to:  localhost:9000

## Testing Kafka

### Connect to Kafka single instance

- *docker exec -it "container id" bash/sh*

- p.e docker exec -it broker bash

### create a topic: test

- *kafka-topics --create --topic test --bootstrap-server broker:9092 --replication-factor 1 --partitions 1*

| Commands | Options| Description |
| - | - | - |
| kafka-topics | `--create` | |
| cont... | `--topic [name_of_topic]` | |
| cont... | `--bootstrap-server` | address of kafka server|
| cont... | `replication-factor` | |
| cont... | `partitions` | |

### start a console-producer to test topic

- *kafka-console-producer --topic test --broker-list broker:9092*

### start a console-consumer to test topic

- *kafka-console-consumer --topic test --from-beginning --bootstrap-server broker:9092

## Creating a Client Consumer

### Project: spring-kafka-simple-consumer
- Mission: listen to the test topic and log the values found using sld4j
- Fire up the spring-kafka-simple-consumer
- using the kafka-console-producer and create one or more messages
- you will see the messages in the spring-kafka-simple-consumer console
- log to zipkin

## Creating a Client Producer

### Project: spring-kafka-simple-producer
- Mission: create a message and send it to the test topic
- Fire up the spring-kafka-simple-producer
- using Postman, send a message using the following url: POST:localhost:9998/app/kafka/text
- you will see the messages in the kafka-console-consumer, kafdrop and in spring-kafka-simple-consumer
- log to zipkin

## Creating an Object Producer

## Creating an Object Consumer

## Creating a filter Consumer

## Configuring two kafkas

## Configuring two zookeepers

## Stream API - converting a stream

## Failure - solving a down consumer

## Failure - creating a dead letter queue

## Resilience
