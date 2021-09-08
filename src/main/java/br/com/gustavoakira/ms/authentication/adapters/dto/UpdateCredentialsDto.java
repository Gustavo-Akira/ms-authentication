package br.com.gustavoakira.ms.authentication.adapters.dto;

import lombok.Data;

@Data
public class UpdateCredentialsDto {
    private String username;
    private String password;
}
