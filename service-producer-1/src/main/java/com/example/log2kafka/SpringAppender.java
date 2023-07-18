package com.example.log2kafka;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class SpringAppender extends AppenderBase<ILoggingEvent> {

    static SpringAppenderHelper contextHelper;

    @Override
    protected void append(ILoggingEvent eventObject) {
        if(contextHelper != null) {
            System.out.println(contextHelper.getSpringContext());
        }
    }
}
