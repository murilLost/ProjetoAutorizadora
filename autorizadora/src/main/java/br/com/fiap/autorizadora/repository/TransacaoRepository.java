package br.com.fiap.autorizadora.repository;

import br.com.fiap.autorizadora.entity.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<TransacaoEntity, Integer> {
}
