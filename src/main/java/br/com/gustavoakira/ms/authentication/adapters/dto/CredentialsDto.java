package br.com.gustavoakira.ms.authentication.adapters.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CredentialsDto {
    private String username;
    private String password;
    private UUID userId;
}
