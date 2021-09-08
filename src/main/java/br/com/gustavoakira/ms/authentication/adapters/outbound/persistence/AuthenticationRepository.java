package br.com.gustavoakira.ms.authentication.adapters.outbound.persistence;

import br.com.gustavoakira.ms.authentication.adapters.outbound.persistence.entities.CredentialsEntity;
import br.com.gustavoakira.ms.authentication.application.domain.Credentials;
import br.com.gustavoakira.ms.authentication.application.port.AuthenticationRepositoryPort;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Repository
public class AuthenticationRepository implements AuthenticationRepositoryPort {

    @Autowired
    private SpringDataCredentialsRepository repository;

    @Autowired
    private SecretKeySpec spec;

    @Override
    public String authenticate(Credentials credentials) {
        CredentialsEntity entity = repository.getCredentialByEmailAndPassword(credentials.getUsername(),credentials.getPassword());
        String jwt = Jwts.builder()
                .signWith(spec)
                .setSubject(entity.getUserId().toString())
                .claim("userId",entity.getUserId())
                .compact();
        return jwt;
    }

    @Override
    public String validateJwt(String jwt) {
        if(!jwt.isEmpty()){
            String user = Jwts.parser().setSigningKey(spec).parseClaimsJws(jwt).getBody().getSubject();
            if(user != null){
                return Jwts.parser().setSigningKey(spec).parseClaimsJws(jwt).getBody().get("userId",String.class);
            }
        }
        return null;
    }

}
