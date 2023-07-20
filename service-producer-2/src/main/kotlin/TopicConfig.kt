import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@Configuration
class TopicConfig {

    @Bean
    fun logTopic() = NewTopic("logs",10, 1)
}
