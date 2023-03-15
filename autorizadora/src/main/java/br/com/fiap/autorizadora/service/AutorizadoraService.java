package br.com.fiap.autorizadora.service;

import br.com.fiap.autorizadora.dto.TransacaoDTO;
import br.com.fiap.autorizadora.dto.TransacaoSimpleDTO;
import br.com.fiap.autorizadora.dto.TransacoesConsultaDTO;

import java.util.List;

public interface AutorizadoraService {

    String pagamento(TransacaoDTO transacaoDTO);

    List<TransacaoSimpleDTO> extrato(TransacoesConsultaDTO transacoesConsultaDTO);

}
