package br.com.gustavoakira.ms.authentication.adapters.outbound.persistence;

import br.com.gustavoakira.ms.authentication.adapters.outbound.persistence.entities.CredentialsEntity;
import br.com.gustavoakira.ms.authentication.application.domain.Credentials;
import br.com.gustavoakira.ms.authentication.application.port.CredentialsRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CredentialsRepository implements CredentialsRepositoryPort {

    @Autowired
    private SpringDataCredentialsRepository credentialsRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Credentials insert(Credentials credentials) {
        return mapper.map(credentialsRepository.save(mapper.map(credentials, CredentialsEntity.class)),Credentials.class);
    }

    @Override
    public Credentials update(UUID id, Credentials credentials) {
        getCredentials(id);
        credentials.setId(id);
        return mapper.map(credentialsRepository.save(mapper.map(credentials,CredentialsEntity.class)),Credentials.class);
    }

    @Override
    public Credentials update(UUID id, String password) {
        CredentialsEntity entity = this.credentialsRepository.findById(id).orElseThrow();
        entity.setPassword(password);
        return mapper.map(credentialsRepository.save(entity),Credentials.class);
    }

    @Override
    public Credentials remove(UUID id) {
        CredentialsEntity entity = this.credentialsRepository.findById(id).orElseThrow();
        credentialsRepository.delete(entity);
        return mapper.map(entity,Credentials.class);
    }

    @Override
    public Credentials getCredentials(UUID id) {
        return mapper.map(credentialsRepository.findById(id).orElseThrow(),Credentials.class);
    }
}
