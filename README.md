# service-broker-kafka

Small proof of concept on how to route log messages from one app to a log
consumer through a kafka broker

## how to run the broker

- install docker, docker-compose

```bash
cd service-broker-kafka
docker compose -f docker-compose-dev.yml up
```

Install [intellij kafka plugin](https://plugins.jetbrains.com/plugin/21704-kafka)
or any other kafka client

Connect on port **9094**

## how to run the service-producer-1

- install java-jdk-17, some IDE (intellij is better)

```bash
cd service-producer-1
sh ./gradlew build ; sh ./gradlew bootRun
```
