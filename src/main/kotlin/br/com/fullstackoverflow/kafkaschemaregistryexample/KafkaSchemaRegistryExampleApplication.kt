package br.com.fullstackoverflow.kafkaschemaregistryexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaSchemaRegistryExampleApplication

fun main(args: Array<String>) {
	runApplication<KafkaSchemaRegistryExampleApplication>(*args)
}
