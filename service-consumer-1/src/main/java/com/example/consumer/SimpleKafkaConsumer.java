package com.example.consumer;

import com.example.config.Configs;
import org.apache.kafka.clients.admin.AdminClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SimpleKafkaConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleKafkaConsumer.class);
    private final Executor service = Executors.newCachedThreadPool();

    private final AdminClient adminClient;

    public SimpleKafkaConsumer(Configs configs) {

        adminClient = AdminClient.create(configs.getProperties());

        Executors.newCachedThreadPool().submit(() -> {/*...*/
            while (true) {

                LOG.info("consuming");
                Thread.sleep(5000);
            }
        });
    }

    public List<String> listTopics() throws Exception {
        return adminClient.listTopics().names().get().stream().toList();
    }
}
