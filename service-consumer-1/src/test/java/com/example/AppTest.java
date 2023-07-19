package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void shouldLoadDefaultProperties() throws Exception {
        KafkaConsumerApp app = new KafkaConsumerApp();
        Assertions.assertEquals(7070, app.configs.getPort());
    }
}