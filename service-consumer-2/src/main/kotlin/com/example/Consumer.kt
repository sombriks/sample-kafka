package com.example

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class Consumer {

    private val logger by lazy { LoggerFactory.getLogger(Consumer::class.java) }

    @KafkaListener(id = "log-group", topics = ["logs"])
    fun listen(message: String) {
        logger.info("message: {}", message)
    }
}
