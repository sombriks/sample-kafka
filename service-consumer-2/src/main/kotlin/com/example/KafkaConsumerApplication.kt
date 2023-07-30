package com.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KafkaConsumerApplication

fun main(args: Array<String>) {
	SpringApplication.run(KafkaConsumerApplication::class.java, *args)
}
