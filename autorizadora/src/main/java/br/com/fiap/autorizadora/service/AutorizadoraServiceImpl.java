package br.com.fiap.autorizadora.service;


import br.com.fiap.autorizadora.dto.TransacaoDTO;
import br.com.fiap.autorizadora.dto.TransacaoSimpleDTO;
import br.com.fiap.autorizadora.dto.TransacoesConsultaDTO;
import br.com.fiap.autorizadora.entity.CartaoEntity;
import br.com.fiap.autorizadora.entity.TransacaoEntity;
import br.com.fiap.autorizadora.repository.CartaoRepository;
import br.com.fiap.autorizadora.repository.TransacaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorizadoraServiceImpl implements AutorizadoraService {

    //Repository
    private CartaoRepository cartaoRepository;

    private TransacaoRepository transacaoRepository;

    private MailSenderService mailSenderService;

    public AutorizadoraServiceImpl(CartaoRepository cartaoRepository, TransacaoRepository transacaoRepository,MailSenderService mailSenderService) {
        this.cartaoRepository = cartaoRepository;
        this.transacaoRepository = transacaoRepository;
        this.mailSenderService = mailSenderService;
    }

    @Override
    public ResponseEntity<?> pagamento(TransacaoDTO transacaoDTO) {

        CartaoEntity cartaoEntity = cartaoRepository.findById(transacaoDTO.numeroCartao()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Operação Inválida"));
        if(cartaoEntity.getLimite() < transacaoDTO.valor()){
            return ResponseEntity.badRequest().body("Limite Excedido - Transação não autorizada");
        }
        if ((cartaoEntity.getCvv().equals(transacaoDTO.cvvCartao())) &&
                (cartaoEntity.getMesDataExpiracao().equals(transacaoDTO.mesDataExpiracaoCartao())) &&
                (cartaoEntity.getAnoDataExpiracao().equals(transacaoDTO.anoDataExpiracaoCartao()))){
                TransacaoEntity transacaoParaSalvar = new TransacaoEntity(LocalDateTime.now(), transacaoDTO.valor(), cartaoEntity);

            try {
                TransacaoEntity transacaoSalva = transacaoRepository.save(transacaoParaSalvar);
                cartaoEntity.setLimite(cartaoEntity.getLimite() - transacaoDTO.valor());
                cartaoRepository.save(cartaoEntity);

                return ResponseEntity.ok(new TransacaoSimpleDTO(transacaoSalva.getValor(), transacaoSalva.getDataTransacao()));
            }
            catch (Exception e) {
                e.printStackTrace();

                return ResponseEntity.internalServerError().build();
            }
        } else {
            return ResponseEntity.badRequest().body("Dados do cartão inválidos");
        }
    }

    @Override
    public ResponseEntity<String> extratoEmail(TransacoesConsultaDTO transacoesConsultaDTO) {
        List<TransacaoEntity> transacoes = transacaoRepository.findByDataAndCartao(transacoesConsultaDTO.dataInicio(),
                transacoesConsultaDTO.dataFim(), transacoesConsultaDTO.numeroCartao());

        if(transacoes.size() > 0) {
            boolean envioEmail = mailSenderService.sendMail(transacoes, transacoesConsultaDTO.email());
            if (envioEmail) {
                return ResponseEntity.ok("Email enviado com sucesso para o endereço: " + transacoesConsultaDTO.email());
            } else {
                return ResponseEntity.badRequest().body("Falha ao enviar o email");
            }
        } else {
            return ResponseEntity.noContent().build();
        }

    }

}
