package br.com.fiap.autorizadora.repository;

import br.com.fiap.autorizadora.entity.CartaoEntity;
import br.com.fiap.autorizadora.entity.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<TransacaoEntity, Integer> {

    List<TransacaoEntity> findByCartao(CartaoEntity cartaoEntity);



}
