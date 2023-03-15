package br.com.fiap.autorizadora.controller;

import br.com.fiap.autorizadora.dto.CartaoCadastroDTO;
import br.com.fiap.autorizadora.dto.CartaoDTO;
import br.com.fiap.autorizadora.service.CartaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("cartao")
public class CartaoController {

    private CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }


    @GetMapping(value = "{id}")
    public CartaoDTO findById(@PathVariable Integer id){
        return cartaoService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartaoDTO create(@RequestBody CartaoCadastroDTO cartaoCadastroDTO){
        return cartaoService.create(cartaoCadastroDTO);
    }

    @PutMapping("{id}")
    public CartaoDTO update(@PathVariable Integer id, @RequestBody CartaoDTO cartaoDTO){
        return cartaoService.update(id, cartaoDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){ cartaoService.delete(id);}



}