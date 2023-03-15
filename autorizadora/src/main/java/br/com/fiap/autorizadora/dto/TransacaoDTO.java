package br.com.fiap.autorizadora.dto;

import java.time.LocalDate;

public record TransacaoDTO (

    Double valor,
    String numeroCartao,
    Integer cvvCartao,
    LocalDate dataExpiracaoCartao

){

}
