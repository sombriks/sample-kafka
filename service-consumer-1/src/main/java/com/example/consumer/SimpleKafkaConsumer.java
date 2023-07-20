package com.example.consumer;

import com.example.config.Configs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleKafkaConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleKafkaConsumer.class);
    private final ExecutorService service = Executors.newCachedThreadPool();

    private final AdminClient adminClient;

    private final KafkaConsumer<String, String> consumer;

    public SimpleKafkaConsumer(Configs configs) {

        adminClient = AdminClient.create(configs.getProperties());
        consumer = new KafkaConsumer<>(configs.getProperties());

        // TODO make it configurable
        consumer.subscribe(List.of("logs"));

        service.submit(() -> {
            while (true) {
                ConsumerRecords<String, String> result = consumer.poll(Duration.ofSeconds(5));
                for(var message : result.records("logs")) {
                    LOG.info("topic: {}, value: {}", message.topic(), message.value());
                }
            }
        });
    }

    public List<String> listTopics() throws Exception {
        return adminClient.listTopics().names().get().stream().toList();
    }

    public boolean isRunning() {
        return !service.isTerminated();
    }
}
