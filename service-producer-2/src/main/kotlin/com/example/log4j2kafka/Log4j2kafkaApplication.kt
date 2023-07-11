package com.example.log4j2kafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class Log4j2kafkaApplication

fun main(args: Array<String>) {
	runApplication<Log4j2kafkaApplication>(*args)
}
