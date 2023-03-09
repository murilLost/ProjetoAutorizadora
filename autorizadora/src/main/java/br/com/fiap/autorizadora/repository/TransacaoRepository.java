package br.com.fiap.autorizadora.repository;

import br.com.fiap.autorizadora.enity.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<TransacaoEntity, Integer> {
}
