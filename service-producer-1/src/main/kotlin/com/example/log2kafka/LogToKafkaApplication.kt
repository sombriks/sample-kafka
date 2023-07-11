package com.example.log2kafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class LogToKafkaApplication



fun main(args: Array<String>) {
	SpringAppender.ctx = runApplication<LogToKafkaApplication>(*args)
}
