package br.com.gustavoakira.ms.authentication.adapters.outbound.persistence;

import br.com.gustavoakira.ms.authentication.adapters.outbound.persistence.entities.CredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SpringDataCredentialsRepository extends JpaRepository<CredentialsEntity, UUID> {
    @Query("select c from Credentials c where c.username=':username' and c.password=':password'")
    CredentialsEntity getCredentialByEmailAndPassword(String username, String password);
}
