package br.com.fiap.autorizadora.repository;

import br.com.fiap.autorizadora.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findFirstByUserName(String username);
}
