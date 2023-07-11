package com.example.log2kafka;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringAppenderHelper implements ApplicationContextAware {

    private ApplicationContext springContext;

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        springContext = applicationContext;
        SpringAppender.contextHelper = this;
    }

    public ApplicationContext getSpringContext() {
        return springContext;
    }
}
