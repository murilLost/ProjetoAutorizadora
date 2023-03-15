package br.com.fiap.autorizadora.service;

import br.com.fiap.autorizadora.dto.CartaoCadastroDTO;
import br.com.fiap.autorizadora.dto.CartaoDTO;

import java.util.List;

public interface CartaoService {

    List<CartaoDTO> listAll(String numero);

    CartaoDTO get(Integer id);
    CartaoDTO create(CartaoCadastroDTO cartaoDTO);
    CartaoDTO update(Integer id, CartaoDTO cartaoDTO);
    void delete (Integer id);
}
