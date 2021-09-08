package br.com.gustavoakira.ms.authentication.adapters.configuration;

import io.jsonwebtoken.SignatureAlgorithm;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Configuration
public class BeansConfiguration {
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    @Bean
    public SecretKeySpec spec(){
        return new SecretKeySpec(SignatureAlgorithm.HS256.getValue().getBytes(StandardCharsets.UTF_8),SignatureAlgorithm.HS256.getJcaName());
    }
}
