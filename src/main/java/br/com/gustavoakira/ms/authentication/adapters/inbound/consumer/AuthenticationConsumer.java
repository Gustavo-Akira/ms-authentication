package br.com.gustavoakira.ms.authentication.adapters.inbound.consumer;

import br.com.gustavoakira.ms.authentication.application.domain.Credentials;
import br.com.gustavoakira.ms.authentication.application.port.CredentialsServicePort;
import br.com.gustavoakira.ms.core.events.AuthenticationRegistrationMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationConsumer {
    @Autowired
    private CredentialsServicePort port;

    @RabbitListener(queues = "ms-authentication")
    public void consume(AuthenticationRegistrationMessage message){
        port.insert(Credentials.builder()
                .userId(message.getUserId())
                .username(message.getUsername())
                .password(message.getPassword())
                .build());
        System.out.println("Consumido " + message);
    }
}
