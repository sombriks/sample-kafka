package com.example.log4j2kafka

import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.util.*

@Service
class SimpleJob {

    private val logger by lazy { LoggerFactory.getLogger(SimpleJob::class.java) }

    @Scheduled(fixedRate = 5000)
    fun work() {
        logger.info("${Date()}")
    }
}
