package com.example.controllers;

import com.example.consumer.SimpleKafkaConsumer;
import io.javalin.http.Context;

import java.util.ArrayList;

public class ConsumerController {

    private final SimpleKafkaConsumer consumer;

    public ConsumerController(SimpleKafkaConsumer consumer) {
        this.consumer = consumer;
    }

    public void index(Context ctx) {
        ctx.result("Hello world!");
    }

    public void listTopics(Context ctx) {
        ctx.json(new ArrayList<String>());
    }
}
