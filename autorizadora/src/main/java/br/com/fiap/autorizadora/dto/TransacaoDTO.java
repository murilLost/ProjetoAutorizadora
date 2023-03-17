package br.com.fiap.autorizadora.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TransacaoDTO (
    @NotNull(message = "Informe o valor da transação")
    @Min(value = 01, message = "Valor mínimo de R$1,00")
    Double valor,

    @Size(max = 16, min = 16, message = "O número de cartão é inválido")
    String numeroCartao,

    @Max(value = 999, message = "cvv inválido")
    Integer cvvCartao,

    @NotNull(message = "Insira o mês da data de expiração")
    @Size(min = 2, max = 2, message = "Mês da data de expiração inválida - 2 dígitos")
    String mesDataExpiracaoCartao,

    @NotNull(message = "Insira o ano da data de expiração")
    @Size(min = 4, max = 4, message = "Ano da data de expiração inválida - 4 dígitos")
    String anoDataExpiracaoCartao

){

}
