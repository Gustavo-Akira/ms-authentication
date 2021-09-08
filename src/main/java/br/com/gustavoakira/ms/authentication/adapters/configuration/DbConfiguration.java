package br.com.gustavoakira.ms.authentication.adapters.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfiguration {

    @Value("${db.config.url}")
    private String url;
    @Value("${db.config.username}")
    private String username;
    @Value("${db.config.password}")
    private String password;


    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .url(url)
                .password(password)
                .username(username)
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}
