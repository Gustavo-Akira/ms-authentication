package br.com.gustavoakira.ms.authentication.adapters.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;


@Configuration
public class RabbitMqConfiguration {
    @Bean
    public Queue queue(){
        return new Queue("ms-authentication");
    }

    @Bean
    public Queue queue1(){
        return new Queue("ms-user");
    }
}
