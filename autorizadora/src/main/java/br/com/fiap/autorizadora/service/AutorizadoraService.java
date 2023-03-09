package br.com.fiap.autorizadora.service;

import br.com.fiap.autorizadora.dto.TransacaoDTO;

public interface AutorizadoraService {

    TransacaoDTO pagamento(TransacaoDTO transacaoDTO);

}
