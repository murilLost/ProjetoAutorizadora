package br.com.fiap.autorizadora.service;

import br.com.fiap.autorizadora.dto.CartaoCadastroDTO;
import br.com.fiap.autorizadora.dto.CartaoDTO;
import br.com.fiap.autorizadora.entity.CartaoEntity;
import br.com.fiap.autorizadora.repository.CartaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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
    public List<CartaoDTO> listAll(String numero) {
        return null;
    }

    @Override
    public CartaoDTO get(Integer id) {
        return null;
    }

    @Override
    public CartaoDTO create(CartaoCadastroDTO cartaoCadastroDTO) {
        LocalDate dataExpiracao = criarDataExpiracao();
        String numeroCartao = criarNumeroCartao();
        Integer cvv = criarCVV();
        double limite = 5000;
        CartaoEntity cartaoCriado = new CartaoEntity(numeroCartao, cartaoCadastroDTO.idAluno(), cvv, dataExpiracao, limite);
        CartaoEntity cartaoSalvo = cartaoRepository.save(cartaoCriado);

        System.out.println(cartaoSalvo.toString());
        return objectMapper.convertValue(cartaoSalvo, CartaoDTO.class);
    }

    private Integer criarCVV() {
        return new Random().nextInt(999);
    }

    private String criarNumeroCartao() {
        int bandeira = 5783;
        int sequencia1 = new Random().nextInt(7999);
        int sequencia2 = new Random().nextInt(7999);
        int sequencia3 = new Random().nextInt(7999);
        return String.valueOf(""+bandeira+sequencia1+sequencia2+sequencia3);
    }

    private LocalDate criarDataExpiracao() {
        return LocalDate.now().plusYears(5);
    }

    @Override
    public CartaoDTO update(Integer id, CartaoDTO cartaoDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
