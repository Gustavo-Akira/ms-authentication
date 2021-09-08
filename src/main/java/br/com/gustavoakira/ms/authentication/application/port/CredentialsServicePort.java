package br.com.gustavoakira.ms.authentication.application.port;

import br.com.gustavoakira.ms.authentication.application.domain.Credentials;

import java.util.UUID;

public interface CredentialsServicePort{
    Credentials insert(Credentials credentials);
    Credentials update(UUID id, Credentials credentials);
    Credentials update(UUID id, String password);
    Credentials remove(UUID id);
    Credentials getCredentials(UUID id);
}
