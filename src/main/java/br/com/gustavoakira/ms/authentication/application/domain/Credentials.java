package br.com.gustavoakira.ms.authentication.application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Credentials {
    private UUID id;
    private String username;
    private String password;
    private UUID userId;
    private Integer level;
    private String jwt;
}
