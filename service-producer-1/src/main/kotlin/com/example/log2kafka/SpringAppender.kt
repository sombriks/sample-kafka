package com.example.log2kafka

import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.AppenderBase
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.stereotype.Service

class SpringAppender : AppenderBase<ILoggingEvent>() {
    override fun append(eventObject: ILoggingEvent?) {
//        TODO("send message to kafka topic")
        println(eventObject)
        if (ctx != null) {
            println(ctx)
        }
    }

    companion object {
        var ctx: ConfigurableApplicationContext? = null
    }
}
