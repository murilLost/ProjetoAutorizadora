package br.com.fiap.autorizadora.repository;

import br.com.fiap.autorizadora.entity.CartaoEntity;
import br.com.fiap.autorizadora.entity.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<TransacaoEntity, Integer> {

    List<TransacaoEntity> findByCartao(CartaoEntity cartaoEntity);

    @Query(value = "SELECT * FROM tb_transacao t WHERE t.data_transacao >= :dataInicio AND t.data_transacao <= :dataFim AND t.cartao_numero = :numeroCartao", nativeQuery = true)
    List<TransacaoEntity> findByDataAndCartao(@Param("dataInicio") LocalDateTime dataInicio, @Param("dataFim") LocalDateTime dataFim, @Param("numeroCartao") String numeroCartao);


}
