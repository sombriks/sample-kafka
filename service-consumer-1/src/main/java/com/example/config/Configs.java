package com.example.config;

import com.example.KafkaConsumerApp;

import java.util.Properties;

public class Configs {

    final String resourceName = "/consumer-app.properties";

    final Properties properties = new Properties();

    private int port;

    public Configs() throws Exception {
        loadProps();
        loadEnv();
    }

    private void loadProps() throws Exception {
        String customProps = System.getenv("PROPS_FILE");
        String propertiesResource = customProps != null ? customProps : resourceName;
        this.properties.load(KafkaConsumerApp.class.getResourceAsStream(propertiesResource));
        port = Integer.parseInt(this.properties.getProperty("port", "7070"));
    }

    private void loadEnv() {
        String sPort = System.getenv("PORT");
        if (sPort != null) {
            port = Integer.parseInt(sPort);
        }
        String bServers = System.getenv("BOOTSTRAP_SERVERS");
        if (bServers != null) {
            properties.setProperty("bootstrap-servers", bServers);
        }
    }

    public Properties getProperties(){
        return properties;
    }

    public int getPort() {
        return port;
    }
}
