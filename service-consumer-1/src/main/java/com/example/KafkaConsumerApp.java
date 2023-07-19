package com.example;

import com.example.config.Configs;
import com.example.consumer.SimpleKafkaConsumer;
import com.example.controllers.ConsumerController;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

public class KafkaConsumerApp {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumerApp.class);

    final Configs configs = new Configs();

    final Javalin server;

    SimpleKafkaConsumer consumer;
    ConsumerController controller;

    public KafkaConsumerApp() throws Exception {

        consumer = new SimpleKafkaConsumer(configs);
        controller = new ConsumerController(consumer);

        server = Javalin.create(javalinConfig -> {
            javalinConfig.requestLogger.http((ctx, ms) -> {
                LOG.info("[{}][{} ms]", ctx.req().getPathInfo(), ms);
            });
        }).routes(() -> {
            get("/", controller::index);
            path("topics", () -> {
                get(controller::listTopics);
            });
        });
    }

    public static void main(String[] args) throws Exception {
        KafkaConsumerApp kafkaConsumerApp = new KafkaConsumerApp();
        kafkaConsumerApp.server.start(kafkaConsumerApp.configs.getPort());
    }
}