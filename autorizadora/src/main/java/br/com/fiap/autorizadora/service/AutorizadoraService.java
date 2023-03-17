package br.com.fiap.autorizadora.service;

import br.com.fiap.autorizadora.dto.TransacaoDTO;
import br.com.fiap.autorizadora.dto.TransacaoSimpleDTO;
import br.com.fiap.autorizadora.dto.TransacoesConsultaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AutorizadoraService {

    ResponseEntity<?> pagamento(TransacaoDTO transacaoDTO);

    ResponseEntity<String> extratoEmail(TransacoesConsultaDTO transacoesConsultaDTO);

}
