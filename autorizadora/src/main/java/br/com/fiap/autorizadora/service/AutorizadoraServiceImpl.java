package br.com.fiap.autorizadora.service;

import br.com.fiap.autorizadora.dto.TransacaoDTO;
import br.com.fiap.autorizadora.entity.TransacaoEntity;
import br.com.fiap.autorizadora.repository.CartaoRepository;
import br.com.fiap.autorizadora.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class AutorizadoraServiceImpl implements AutorizadoraService {

    //Repository
    private CartaoRepository cartaoRepository;

    private TransacaoRepository transacaoRepository;

    @Override
    public TransacaoDTO pagamento(TransacaoDTO transacaoDTO) {

        TransacaoEntity transacaoParaSalvar = new TransacaoEntity();

        TransacaoEntity transacaoSalva = transacaoRepository.save(transacaoParaSalvar);
        return new TransacaoDTO();
    }
}
