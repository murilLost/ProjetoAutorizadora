package br.com.fiap.autorizadora.service;

import br.com.fiap.autorizadora.dto.CartaoCadastroDTO;
import br.com.fiap.autorizadora.dto.CartaoDTO;
import br.com.fiap.autorizadora.entity.CartaoEntity;
import br.com.fiap.autorizadora.model.DataExpiracaoModel;
import br.com.fiap.autorizadora.repository.CartaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
public class CartaoServiceImpl implements CartaoService{

    private final CartaoRepository cartaoRepository;

    private ObjectMapper objectMapper;

    public CartaoServiceImpl(CartaoRepository cartaoRepository, ObjectMapper objectMapper) {
        this.cartaoRepository = cartaoRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseEntity<CartaoDTO> create(CartaoCadastroDTO cartaoCadastroDTO, UriComponentsBuilder uriBuilder) {
        DataExpiracaoModel dataExpiracao = criarDataExpiracao();

        String numeroCartao = criarNumeroCartao();

        Integer cvv = criarCVV();

        double limite = 5000.00;

        CartaoEntity cartaoCriado = new CartaoEntity(
                numeroCartao,
                cartaoCadastroDTO.idAluno(),
                cvv,
                dataExpiracao.getMesDataExpiracao(),
                dataExpiracao.getAnoDataExpiracao(),
                limite
        );
        CartaoEntity cartaoSalvo = cartaoRepository.save(cartaoCriado);

        URI uri = uriBuilder.path("/cartao/{numero}").buildAndExpand(cartaoCriado.getNumero()).toUri();
        return ResponseEntity.created(uri).body(objectMapper.convertValue(cartaoSalvo, CartaoDTO.class));
    }

    private Integer criarCVV() {
        return new Random().nextInt(999);
    }

    private String criarNumeroCartao() {
        int bandeira = 5783;
        int sequencia1 = new Random().nextInt(7999);
        int sequencia2 = new Random().nextInt(7999);
        int sequencia3 = new Random().nextInt(7999);
        return ""+bandeira+sequencia1+sequencia2+sequencia3;
    }

    private DataExpiracaoModel criarDataExpiracao() {
        DateTimeFormatter mesFormato = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter anoFormato = DateTimeFormatter.ofPattern("yyyy");

        LocalDate dataCriada = LocalDate.now().plusYears(5);

        return new DataExpiracaoModel(dataCriada.format(mesFormato), dataCriada.format(anoFormato));
    }

}
