package br.com.fiap.autorizadora.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record TransacoesConsultaDTO(
        @Size(max = 16, min = 16, message = "O número de cartão inválido")
        String numeroCartao,
        @NotNull(message = "Informar data de início")
        LocalDateTime dataInicio,
        @NotNull(message = "Informar data final")
        LocalDateTime dataFim,
        @NotNull(message = "Informar o e-mail")
        @Size(min = 4, message = "Email invalido")
        String email

) {

}