package br.com.fiap.autorizadora.repository;

import br.com.fiap.autorizadora.entity.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<CartaoEntity, Long> {

}
