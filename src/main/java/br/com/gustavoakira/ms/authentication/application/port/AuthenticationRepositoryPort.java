package br.com.gustavoakira.ms.authentication.application.port;

import br.com.gustavoakira.ms.authentication.application.domain.Credentials;

public interface AuthenticationRepositoryPort {
    String authenticate(Credentials credentials);
    String validateJwt(String jwt);
}
