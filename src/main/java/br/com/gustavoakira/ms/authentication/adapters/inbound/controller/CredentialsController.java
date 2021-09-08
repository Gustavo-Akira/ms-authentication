package br.com.gustavoakira.ms.authentication.adapters.inbound.controller;

import br.com.gustavoakira.ms.authentication.adapters.dto.CredentialsDto;
import br.com.gustavoakira.ms.authentication.application.domain.Credentials;
import br.com.gustavoakira.ms.authentication.application.port.CredentialsServicePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("credential")
public class CredentialsController {

    @Autowired
    private CredentialsServicePort port;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("{id}")
    public Credentials getCredentials(@PathVariable UUID id){
        return port.getCredentials(id);
    }

    @PostMapping()
    public Credentials saveCredential(@RequestBody CredentialsDto credentials){
        return port.insert(mapper.map(credentials,Credentials.class));
    }

    @PatchMapping("{id}/password")
    public Credentials updateCredential(@PathVariable UUID id,@RequestBody String password){
        return port.update(id,password);
    }
    @PutMapping("{id}")
    public Credentials updateCredential(@PathVariable UUID id,@RequestBody CredentialsDto dto){
        return port.update(id,mapper.map(dto,Credentials.class));
    }

    @DeleteMapping("{id}")
    public Credentials remove(@PathVariable UUID id){
        return port.remove(id);
    }
}
