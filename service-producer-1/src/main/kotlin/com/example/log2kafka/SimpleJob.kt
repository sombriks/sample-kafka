package com.example.log2kafka

import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.util.*

@Service
class SimpleJob(val template: KafkaTemplate<String?, String?>) {

    private val logger by lazy { LoggerFactory.getLogger(SimpleJob::class.java) }

    @Scheduled(fixedRate = 5000)
    fun work() {
        val date = "service-producer-1 - ${Date()}"
        logger.info(date)
        template.send("logs", date)
    }
}
