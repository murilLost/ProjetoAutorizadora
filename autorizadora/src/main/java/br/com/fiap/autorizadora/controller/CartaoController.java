package br.com.fiap.autorizadora.controller;

import br.com.fiap.autorizadora.dto.CartaoCadastroDTO;
import br.com.fiap.autorizadora.dto.CartaoDTO;
import br.com.fiap.autorizadora.service.CartaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController()
@RequestMapping("cartao")
public class CartaoController {

    private CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    @PostMapping
    public ResponseEntity<CartaoDTO> create(@RequestBody CartaoCadastroDTO cartaoCadastroDTO, UriComponentsBuilder uriBuilder){
        return cartaoService.create(cartaoCadastroDTO, uriBuilder);
    }

}