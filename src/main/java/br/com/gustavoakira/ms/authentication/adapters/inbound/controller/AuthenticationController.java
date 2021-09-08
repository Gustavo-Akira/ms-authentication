package br.com.gustavoakira.ms.authentication.adapters.inbound.controller;

import br.com.gustavoakira.ms.authentication.adapters.dto.CredentialsDto;
import br.com.gustavoakira.ms.authentication.application.domain.Credentials;
import br.com.gustavoakira.ms.authentication.application.port.AuthenticationServicePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
    @Autowired
    private AuthenticationServicePort port;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public String authenticate(@RequestBody CredentialsDto credentials){
        return port.authenticate(mapper.map(credentials,Credentials.class));
    }

    @GetMapping("/validate")
    public String isValid(@RequestBody String jwt){
        return port.validateJwt(jwt);
    }
}
