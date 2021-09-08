package br.com.gustavoakira.ms.authentication.application.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class Credentials {
    private UUID id;
    private String username;
    private String password;
    private UUID userId;
    private String jwt;
}
