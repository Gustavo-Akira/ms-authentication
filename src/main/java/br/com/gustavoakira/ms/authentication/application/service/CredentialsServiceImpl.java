package br.com.gustavoakira.ms.authentication.application.service;

import br.com.gustavoakira.ms.authentication.application.domain.Credentials;
import br.com.gustavoakira.ms.authentication.application.port.CredentialsRepositoryPort;
import br.com.gustavoakira.ms.authentication.application.port.CredentialsServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CredentialsServiceImpl implements CredentialsServicePort {

    @Autowired
    private CredentialsRepositoryPort port;

    @Override
    public Credentials insert(Credentials credentials) {
        return port.insert(credentials);
    }

    @Override
    public Credentials update(UUID id, Credentials credentials) {
        return port.update(id,credentials);
    }

    @Override
    public Credentials update(UUID id, String password) {
        return port.update(id,password);
    }

    @Override
    public Credentials remove(UUID id) {
        return port.remove(id);
    }

    @Override
    public Credentials getCredentials(UUID id) {
        return port.getCredentials(id);
    }
}
