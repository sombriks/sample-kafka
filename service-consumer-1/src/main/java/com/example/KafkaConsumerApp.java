package com.example;

import com.example.consumer.SimpleKafkaConsumer;
import com.example.controllers.ConsumerController;
import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

import static io.javalin.apibuilder.ApiBuilder.*;

public class KafkaConsumerApp {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumerApp.class);

    final String propsName = "/consumer-app.properties";

    final Properties props = new Properties();
    final Javalin server;

    String bootstrapServers;

    int port;

    SimpleKafkaConsumer consumer;
    ConsumerController controller;

    private void loadProps() throws Exception {
        String customProps = System.getenv("PROPS_FILE");
        String properties = customProps != null ? customProps : propsName;
        props.load(KafkaConsumerApp.class.getResourceAsStream(properties));
        port = Integer.parseInt(props.getProperty("port", "7070"));
        bootstrapServers = props.getProperty("bootstrap-servers", "localhost:9094");
    }

    private void loadEnv() {
        String sPort = System.getenv("PORT");
        if (sPort != null) {
            port = Integer.parseInt(sPort);
        }
        String bServers = System.getenv("BOOTSTRAP_SERVERS");
        if (bServers != null) {
            bootstrapServers = bServers;
        }
    }

    public KafkaConsumerApp() throws Exception {
        loadProps();
        loadEnv();

        consumer = new SimpleKafkaConsumer();

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
        kafkaConsumerApp.server.start(kafkaConsumerApp.port);
    }
}