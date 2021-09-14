package br.com.gustavoakira.ms.authentication.adapters.outbound.persistence;

import br.com.gustavoakira.ms.authentication.adapters.outbound.persistence.entities.CredentialsEntity;
import br.com.gustavoakira.ms.authentication.application.domain.Credentials;
import br.com.gustavoakira.ms.authentication.application.port.AuthenticationRepositoryPort;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.JacksonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.security.Key;

@Repository
public class AuthenticationRepository implements AuthenticationRepositoryPort {

    @Autowired
    private SpringDataCredentialsRepository repository;

    @Autowired
    private Key spec;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String authenticate(Credentials credentials) {

        CredentialsEntity entity = repository.getCredentialByEmailAndPassword(credentials.getUsername(),credentials.getPassword());
        String jwt = Jwts.builder()
                .serializeToJsonWith(new JacksonSerializer<>(objectMapper))
                .signWith(spec)
                .setSubject(entity.getUserId().toString())
                .claim("userId",entity.getUserId())
                .compact();
        entity.setJwt(jwt);
        repository.save(entity);
        return jwt;
    }

    @Override
    public String validateJwt(String jwt) {
        if(!jwt.isEmpty()){
            jwt = jwt.trim();
            String user = Jwts.parser().setSigningKey(spec).parseClaimsJws(jwt).getBody().getSubject();
            if(user != null){
                return Jwts.parser().setSigningKey(spec).parseClaimsJws(jwt).getBody().get("userId",String.class);
            }
        }
        return null;
    }

}
