package br.com.gustavoakira.ms.authentication.application.service;

import br.com.gustavoakira.ms.authentication.adapters.dto.JwtDto;
import br.com.gustavoakira.ms.authentication.application.domain.Credentials;
import br.com.gustavoakira.ms.authentication.application.port.AuthenticationRepositoryPort;
import br.com.gustavoakira.ms.authentication.application.port.AuthenticationServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationServicePort {
    @Autowired
    private AuthenticationRepositoryPort port;

    @Override
    public String authenticate(Credentials credentials) {
        return port.authenticate(credentials);
    }

    @Override
    public String validateJwt(String jwt) {
        return port.validateJwt(jwt);
    }

}
