package br.com.fiap.autorizadora.service;

import br.com.fiap.autorizadora.dto.CartaoCadastroDTO;
import br.com.fiap.autorizadora.dto.CartaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public interface CartaoService {

    ResponseEntity<CartaoDTO> create(CartaoCadastroDTO cartaoDTO, UriComponentsBuilder uriBuilder);

}
