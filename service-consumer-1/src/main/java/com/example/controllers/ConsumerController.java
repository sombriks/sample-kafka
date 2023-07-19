package com.example.controllers;

import com.example.consumer.SimpleKafkaConsumer;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.Optional;

public class ConsumerController {

    private final SimpleKafkaConsumer consumer;

    public ConsumerController(SimpleKafkaConsumer consumer) {
        this.consumer = consumer;
    }

    public void index(Context ctx) {
        ctx.result("Hello world!");
    }

    public void listTopics(Context ctx) {
        try {
            ctx.json(consumer.listTopics());
        } catch (Exception e) {
            ctx.status(500).json(e);
        }
    }
}
