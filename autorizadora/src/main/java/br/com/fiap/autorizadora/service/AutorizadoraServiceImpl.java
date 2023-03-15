package br.com.fiap.autorizadora.service;

import br.com.fiap.autorizadora.dto.TransacaoDTO;
import br.com.fiap.autorizadora.dto.TransacaoSimpleDTO;
import br.com.fiap.autorizadora.dto.TransacoesConsultaDTO;
import br.com.fiap.autorizadora.entity.CartaoEntity;
import br.com.fiap.autorizadora.entity.TransacaoEntity;
import br.com.fiap.autorizadora.repository.CartaoRepository;
import br.com.fiap.autorizadora.repository.TransacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorizadoraServiceImpl implements AutorizadoraService {

    //Repository
    private CartaoRepository cartaoRepository;

    private TransacaoRepository transacaoRepository;

    public AutorizadoraServiceImpl(CartaoRepository cartaoRepository, TransacaoRepository transacaoRepository) {
        this.cartaoRepository = cartaoRepository;
        this.transacaoRepository = transacaoRepository;
    }

    @Override
    public String pagamento(TransacaoDTO transacaoDTO) {

        CartaoEntity cartaoEntity = cartaoRepository.findById(transacaoDTO.numeroCartao()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cartao.not.found"));
        TransacaoEntity transacaoParaSalvar = new TransacaoEntity(LocalDateTime.now(), transacaoDTO.valor(), cartaoEntity);

        try {
            TransacaoEntity transacaoSalva = transacaoRepository.save(transacaoParaSalvar);
            System.out.println(transacaoSalva.getValor());
            return "Pagamento efeutada com sucesso";
        }
        catch (Exception e) {
            return "Erro ao efetuar pagamento" + e.getMessage();
        }
    }

    @Override
    public List<TransacaoSimpleDTO> extrato(TransacoesConsultaDTO transacoesConsultaDTO) {
        CartaoEntity cartaoEntity = cartaoRepository.findById(transacoesConsultaDTO.numeroCartao()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cartao.not.found"));

        System.out.println(cartaoEntity);
        return cartaoEntity.getTransacoes()
                .stream()
                .map(transacaoEntity -> new TransacaoSimpleDTO(
                        transacaoEntity.getValor(),
                        transacaoEntity.getDataTransacao()))
                .collect(Collectors.toList());
    }

}
